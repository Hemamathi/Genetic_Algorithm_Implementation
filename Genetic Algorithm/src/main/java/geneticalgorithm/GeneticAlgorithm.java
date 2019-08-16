                /*
                 * To change this license header, choose License Headers in Project Properties.
                 * To change this template file, choose Tools | Templates
                 * and open the template in the editor.
                 */
                package geneticalgorithm;

                import java.util.ArrayList;
                import java.util.stream.IntStream;
                /*
                 * <h1> To Implement a Genetic Algorithm Class </h1>
                 */

                
                public class GeneticAlgorithm {
                    private Data data;

                    public GeneticAlgorithm(Data data) {
                        this.data = data;
                    }

                    /**
                     * For the given input population, it returns a population which is mutated and CrossOver
                     *
                     * @param population
                     * @return population
                     */
                    public Population evolve(Population population) {
                        return mutatePopulation(crossoverPopulation(population));
                    }

                    /**
                     * For the given input population, it returns a population from the cross over of schedules which is greater than cross over rate
                     *
                     * @param population
                     * @return population
                     */
                    public Population crossoverPopulation(Population population) {
                        Population crossoverPopulation = new Population(population.getSchedules().size(), data);
                        IntStream.range(0, Main.NUMB_OF_ELITE_SCHEDULES).forEach(x -> crossoverPopulation.getSchedules().set(x,
                                population.getSchedules().get(x)));
                        IntStream.range(Main.NUMB_OF_ELITE_SCHEDULES, population.getSchedules().size()).forEach(x -> {
                            if (Main.CROSSOVER_RATE > Math.random()) {
                                ClassSchedule schedule1 = selectTournamentPopulation(population).sortByFitness().getSchedules().get(0);
                                ClassSchedule schedule2 = selectTournamentPopulation(population).sortByFitness().getSchedules().get(0);
                                crossoverPopulation.getSchedules().set(x, crossoverSchedule(schedule1, schedule2));
                            } else crossoverPopulation.getSchedules().set(x, population.getSchedules().get(x));
                        });
                        return crossoverPopulation;
                    }

                    /**
                     * For the input class schedules, it gives a schedule based on a random function
                     *
                     * @param schedule1
                     * @param schedule2
                     * @return crossoverSchedule from the given input classSchedules
                     */
                    public ClassSchedule crossoverSchedule(ClassSchedule schedule1, ClassSchedule schedule2) {
                        ClassSchedule crossoverSchedule = new ClassSchedule(data).initialize();
                        IntStream.range(0, crossoverSchedule.getClasses().size()).forEach(x -> {
                            if (Math.random() > 0.5)
                                crossoverSchedule.getClasses().set(x, schedule1.getClasses().get(x));
                            else crossoverSchedule.getClasses().set(x, schedule2.getClasses().get(x));
                        });
                        return crossoverSchedule;
                    }

                    /**
                     * For the given Population, it returns a mutated population based on the number of elite schedules
                     *
                     * @param population
                     * @return mutatedPopulation
                     */
                    public Population mutatePopulation(Population population) {
                        Population mutatePopulation = new Population(population.getSchedules().size(), data);
                        ArrayList<ClassSchedule> schedules = mutatePopulation.getSchedules();
                        IntStream.range(0, Main.NUMB_OF_ELITE_SCHEDULES).forEach(x -> schedules.set(x, population.getSchedules().get(x)));
                        IntStream.range(Main.NUMB_OF_ELITE_SCHEDULES, population.getSchedules().size()).forEach(x -> {
                            schedules.set(x, mutateSchedule(population.getSchedules().get(x)));
                        });
                        return mutatePopulation;
                    }

                    /**
                     * From the given ClassSchedule input it gives the class schedule greater than the Mutation rate
                     *
                     * @param mutateSchedule
                     * @return a mutated classSchedule
                     */
                    public ClassSchedule mutateSchedule(ClassSchedule mutateSchedule) {
                        ClassSchedule schedule = new ClassSchedule(data).initialize();
                        IntStream.range(0, mutateSchedule.getClasses().size()).forEach(x -> {
                            if (Main.MUTATION_RATE > Math.random())
                                mutateSchedule.getClasses().set(x, schedule.getClasses().get(x));
                        });
                        return mutateSchedule;
                    }

                    /**
                     * From the Passed list to population it gives the best population from the tournament size.
                     *
                     * @param population
                     * @return selected population from the tournament selection size
                     */
                    public Population selectTournamentPopulation(Population population) {
                        Population tournamentPopulation = new Population(Main.TOURNAMENT_SELECTION_SIZE, data);
                        IntStream.range(0, Main.TOURNAMENT_SELECTION_SIZE).forEach(x -> {
                            tournamentPopulation.getSchedules().set(x,
                                    population.getSchedules().get((int) (Math.random() * population.getSchedules().size())));
                        });
                        return tournamentPopulation;
                    }
                }
