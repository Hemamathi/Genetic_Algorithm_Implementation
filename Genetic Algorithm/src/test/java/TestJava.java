/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import geneticalgorithm.ClassSchedule;
import geneticalgorithm.Data;
import geneticalgorithm.GeneticAlgorithm;
import geneticalgorithm.Main;
import geneticalgorithm.Population;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestJava {
    Data data;
    Main main;
    GeneticAlgorithm geneticAlgo;

    public TestJava() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        data = new Data();
        main = new Main();
        geneticAlgo = new GeneticAlgorithm(data);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void TestselectTournamentPopulation() {

        Population test = new Population(main.POPULATION_SIZE, data);
        Population expected = new Population(main.TOURNAMENT_SELECTION_SIZE, data);

        assertEquals(expected, geneticAlgo.selectTournamentPopulation(test));
        assertEquals(expected.getSchedules().size(), geneticAlgo.selectTournamentPopulation(test).getSchedules().size());
    }

    @Test
    public void TestCrossoverPopulation() {
        //Data d = new Data();
        Population test = new Population(main.POPULATION_SIZE, data);

        Population crossPopu = new Population(main.POPULATION_SIZE, data);
        Population expected = geneticAlgo.crossoverPopulation(crossPopu);
        assertEquals(expected, geneticAlgo.crossoverPopulation(test));
        assertEquals(expected.getSchedules().size(), geneticAlgo.crossoverPopulation(test).getSchedules().size());

    }

    @Test
    public void TestMutatePopulation() {
        //Data d = new Data();
        Population test = new Population(main.POPULATION_SIZE, data);
        Population mutatePopu = new Population(main.POPULATION_SIZE, data);
        Population expected = geneticAlgo.mutatePopulation(mutatePopu);
        assertEquals(expected, geneticAlgo.mutatePopulation(test));
        assertEquals(expected.getSchedules().size(), geneticAlgo.mutatePopulation(test).getSchedules().size());
    }

    @Test
    public void TestMutateSchedule() {
        //Data d = new Data();
        Population mutatePopulation = new Population(main.POPULATION_SIZE, data);
        ClassSchedule test = mutatePopulation.getSchedules().get(0);
        ClassSchedule expected = new ClassSchedule(data).initialize();
        assertEquals(expected, geneticAlgo.mutateSchedule(test));
    }

    @Test
    public void TestCrossOverSchedule() {
        Population population = new Population(main.POPULATION_SIZE, data);
        ClassSchedule expected = new ClassSchedule(data).initialize();
        ClassSchedule schedule1 = geneticAlgo.selectTournamentPopulation(population).sortByFitness().getSchedules().get(0);
        ClassSchedule schedule2 = geneticAlgo.selectTournamentPopulation(population).sortByFitness().getSchedules().get(0);
        assertEquals(expected, geneticAlgo.crossoverSchedule(schedule1, schedule2));
    }


}
