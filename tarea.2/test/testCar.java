/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import File.CarFile;
import domain.Car;
import java.io.File;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author karol
 */
public class testCar {

    public static CarFile carFile;
    public static Car car, c1, c2, c3, c4, c5, c6;

    public testCar() {
    }

    @BeforeClass
    public static void setUpClass() throws IOException {
        File fileCar = new File("./Carrr.dat");

        //instanciar estudiantes
        c1 = new Car("Toyota", 2010, 200, true, 5637);
        c2 = new Car("Nissan", 2000, 1000, false, 5636);
        c3 = new Car("Yariss", 2010, 200, true, 5637);
        c4 = new Car("Samsung", 2000, 1000, false, 5636);
        c5 = new Car("Nokia", 2010, 200, true, 5637);
        c6 = new Car("motorola", 2000, 1000, false, 5636);

        carFile = new CarFile(fileCar);

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    @Test
    public void insertIntoFile() {
        try {
            //insertar en el archivo
            carFile.addEndRecord(c1);
            carFile.addEndRecord(c2);
            carFile.addEndRecord(c3);
            carFile.addEndRecord(c4);
            carFile.addEndRecord(c5);
            carFile.addEndRecord(c6);
     
            //System.out.println(carFile.getAllStudents());//TOTAL REGISTRO
  Car c = carFile.getRead(0);
 System.out.println("toString: "+c.toString());

        } catch (IOException ex) {

        }

    }


}//class