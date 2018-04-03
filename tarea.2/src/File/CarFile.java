/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import interfaceCar.RegisterCar;
import domain.Car;
import domain.Car;

import java.awt.HeadlessException;
import java.io.*;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author karol
 */
public class CarFile {

    public RandomAccessFile randonAcessFile;
    public int regsQuantity;//cantidad del registro en el txt
    public int regSize;//tamno del regitro
    public String myFilePath;//rut
   
    //Constructors
    public CarFile(File file) throws IOException {
        try {
            //almaceno la rut
            myFilePath = file.getPath();
            //indico el taman maximo
            this.regSize = 140;//tamño cada registro

            if (file.exists() && !file.isFile()) {///
                throw new IOException(file.getName() + " is an invalid file");
            } else {
                randonAcessFile = new RandomAccessFile(file, "rw");//leer y escribir archivo
                //se redondea hacia arriba siempre
                this.regsQuantity
                        = (int) Math.ceil((double) randonAcessFile.length() / (double) regSize);
            }
        } catch (IOException e) {
            System.out.println("Error 1, CarFile" + e);
        }

    }

    public void close() throws IOException {
        try {
            randonAcessFile.close();
        } catch (IOException e) {

        }
    }

    public int fileSize() {///Nos devuelve la cantidad de autos registrados, que tenemos en el archivo
        return this.regsQuantity;

    }

    public boolean putValue(int position, Car car) throws IOException {//Este metodo lo que hace es guardar la informacion,  en el objeto
        //try{ 
        if (position < 0 && position > this.regsQuantity) {

            return false;
        } else {
            if (car.size() > this.regSize) {

                return false;

            } else {

                randonAcessFile.seek(position * this.regSize);
                randonAcessFile.writeUTF(car.getName());
                randonAcessFile.writeInt(car.getYear());
                randonAcessFile.writeFloat(car.getMileage());
                randonAcessFile.writeBoolean(car.getAmerican());
                randonAcessFile.writeInt(car.getSeries());

                return true;
            }
        }
        //}catch(Exception e){ System.out.println("Error 3, CarFile");}

    }

    public boolean addEndRecord(Car car) throws IOException {//Este metodo nos permite escribir  en el archivo

        boolean sucess = putValue(this.regsQuantity, car);
        try {
            if (sucess) {
                this.regsQuantity++;
            }
        } catch (Exception e) {

        }
        return sucess;
    }
    //de aqui pra arriba esta bien 

    public Car getRead(int position) throws IOException {//este metodo se encarga de extraer la posicion que deseamos obtener
        Car car = new Car();
        try {

            if (position >= 0 && position <= randonAcessFile.length()) {
                randonAcessFile.seek(position * this.regSize);
                car.setName(randonAcessFile.readUTF());
                car.setYear(randonAcessFile.readInt());
                car.setMileage(randonAcessFile.readFloat());
                car.setAmerican(randonAcessFile.readBoolean());
                car.setSeries(randonAcessFile.readInt());

            } else {

                return null;

            }
        } catch (IOException e) {

        }
        return car;

    }

    ///RETURN LIS OF STUDENS
    public ArrayList<Car> getAllStudents() throws IOException {///Este metodo se encarga de guardar todo el registro de vehiculos, en un ArrayList
        ArrayList<Car> carArray = new ArrayList<Car>();
        try {
            for (int i = 0; i < this.regsQuantity; i++) {
                Car car = this.getRead(i);
                if (car != null) {
                    carArray.add(car);
                }
            }
        } catch (IOException e) {

        }
        return carArray;

    }

    public boolean search(int series) throws IOException {//Este metodo se encarga de buscar, por serie el vehiculo que deseamos buscar, 
        Car car;
        try {
            for (int i = 0; i < regsQuantity; i++) {///recorremos la cantidad de vehiculos
                car = this.getRead(i);//en el objeto extramos la posicion
                if (series == car.getSeries()) {//preguntamos, si la variable entre parametros(se extrae del JTextField) es igual al vehiculo registrado
                    JOptionPane.showMessageDialog(null, "Search results: " + " \n Name:" + car.getName() + "\n" + "Year:" + car.getYear() + "\n" + "Mileage:" + car.getMileage() + "\n" + "American:" + car.getAmerican());
                    return this.putValue(i, car);//Si es igual que nos revuelva la informacion, o el valor

                }else{
            //break;
            }
                

            }

            //JOptionPane.showMessageDialog(null, "The vehicle is not registered");//sino, el vehiculo no esta registrado

        } catch (HeadlessException | IOException e) {

        }
        return false;

    }

    public boolean repeat(int series) throws IOException {//Este metodo se encrga de b preguntar si hay series repetidas,

        Car car = new Car();//Instanceamos el objeto 
        boolean salida = false;
        try {
            for (int i = 0; i < regsQuantity; i++) {///recorremos la cantidad de vechiculos que tenemos
                car = this.getRead(i);//leemos la posiicion

                if (series == car.getSeries()) {//preguntamos, si la variable serie entre parametros, que seria lo que obtengo del campo de texto
                    //si esa variable, es igual a la serie registrada
                    JOptionPane.showMessageDialog(null, "This series is not available, please enter another");//me mande un sms de advertencia

                    salida = true;
                    break;
                } else {
                    salida = false;
                }

            }
        } catch (HeadlessException | IOException e) {

        }
        return salida;

    }

    public boolean delete(int series) throws IOException {//Al accion de este metodo, o funcion, es eliminar, por serie
        Car car = new Car();
        boolean salida = false;
        try {
            for (int i = 0; i < regsQuantity; i++) {//recorremos la cantidad de registro
                car = this.getRead(i);//leemos la posicion
                if (series == car.getSeries()) {

                    System.out.println("getSeries() " + car.getSeries() + "serie" + series);
                    int selector = JOptionPane.showOptionDialog(null, "Are you sure, you want delete that", "Options selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, // null para icono por defecto.
                            new Object[]{"Yes ", " No"}, // null para YES, NO y CANCEL
                            "opcion 1");
                    ////Preeguntamos por medio de JOption, si esta seguro en eliminar esa serie
                    if (selector == 0) {//Si la opcion es igual a 0, significa que si
                        car.setName(" ");//Entonces vaciamos las variables
                        car.setYear(0);
                        car.setMileage(0);
                        car.setAmerican(false);
                        car.setSeries(0);
                        this.putValue(i, car);//Y guardamos el valor
                        salida = true;
                        JOptionPane.showMessageDialog(null, "Deleted");//Enviamos un sms, confiarmando, que se ha eliminado correctamente

                    }

                }
//                else {
//                    salida = false;
//                }

            }
            // JOptionPane.showMessageDialog(null, " Date its no found"); 

        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, "Incorrect date");
        }
        return salida;

    }

  public boolean update(String name, int year, boolean american, int series) throws IOException {
        Car car = new Car();
        boolean salida = false;
     //   InterfaceCar in = new InterfaceCar();
//        String name;
//       name=in.fieldName.getText();
        try {
            for (int i = 0; i < regsQuantity; i++) {
                car = this.getRead(i);
                if (series == car.getSeries()) {

                    System.out.println("getSeries() " + car.getSeries() + "serie" + series);
                    int selector = JOptionPane.showOptionDialog(null, "Modify?", "Options selector", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, // null para icono por defecto.
                            new Object[]{"Yes ", " No", "Cancel"}, // null para YES, NO y CANCEL
                            "opcion 1");

                    if (selector == 0) {
                        car.setName(name);
                        System.out.println("Name" + name);
                        car.setYear(year);
                        //car.setMileage(0);
                        car.setAmerican(american);
                        car.setSeries(series);
                        this.putValue(i, car);
                        salida = true;
                        JOptionPane.showMessageDialog(null, "modified");

                    }

                } else {
                    salida = false;
                }

            }
        } catch (HeadlessException | IOException e) {
            System.out.println("Error, 9 CarFile-delete" + e);
        }
        return salida;

    }

}//end class

