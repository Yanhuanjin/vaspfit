package vaspfit;

import java.util.Calendar;

/** 进行计算的Calculator类
 * 初始化时，需指定输入值
 * 使用set和get方法设置和得到对应的值
 */

public class Calculator{
    // Dim the data into Calculator.
    private double Vacuum;
    private double Fermi;
    private double Potential;

    // Non para Constructor.
    // public Calculator(){
    //    this.Vacuum = Double.NaN;
    //    this.Fermi = Double.NaN;
    //}

    // Para Constructor.
    public Calculator(double Vacuum, double Fermi) {
        this.Vacuum = Vacuum;
        this.Fermi = Fermi;
    }

    // Methods.
    public void setFermi(double Fermi){
        this.Fermi = Fermi;
    }

    public void setVacuum(double Vacuum){
        this.Vacuum = Vacuum;
    }

    public double getFermi() {
        return Fermi;
    }

    public double getVacuum(){
        return Vacuum;
    }

    public double getPotential(){
        this.Potential = Vacuum - Fermi;
        return Potential;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator(-1.2d, -5.3d);
        System.out.printf("%.4f%n", c.getFermi());
        System.out.printf("%.4f%n", c.getVacuum());
        System.out.printf("%.4f%n", c.getPotential());
        c.setFermi(-2);
        c.setVacuum(100);
        System.out.println(c.getPotential());
    }
}
