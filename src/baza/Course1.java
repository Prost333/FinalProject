package baza;

import java.io.Serializable;

public class Course1 implements Serializable {


    private double byn;
    private double usd;
    private double eur;
    private double rub;
    private double rubToUsd = usd / rub;
    private double rubToByn = byn / rub;
    private double rubToEur = eur / rub;
    private double usdToRub = rub / usd;
    private double usdToByn = byn / usd;
    private double usdToEur = eur / usd;
    private double bynToUsd = usd / byn;
    private double bynToRub = rub / byn;
    private double bynToEur = eur / byn;
    private double eurToUsd = usd / eur;
    private double eurToRub = rub / eur;
    private double eurToByn = byn / eur;

    public Course1(double byn, double usd, double eur, double rub) {
        this.byn = byn;
        this.usd = usd;
        this.eur = eur;
        this.rub = rub;
    }

    public Course1() {
    }

    public double getByn() {
        return byn;
    }

    public void setByn(double byn) {
        this.byn = byn;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getEur() {
        return eur;
    }

    public void setEur(double eur) {
        this.eur = eur;
    }

    public double getRub() {
        return rub;
    }

    public void setRub(double rub) {
        this.rub = rub;
    }

    public double getRubToUsd() {
        return rubToUsd;
    }

    public void setRubToUsd(double rubToUsd) {
        this.rubToUsd = rubToUsd;
    }

    public double getRubToByn() {
        return rubToByn;
    }

    public void setRubToByn(double rubToByn) {
        this.rubToByn = rubToByn;
    }

    public double getRubToEur() {
        return rubToEur;
    }

    public void setRubToEur(double rubToEur) {
        this.rubToEur = rubToEur;
    }

    public double getUsdToRub() {
        return usdToRub;
    }

    public void setUsdToRub(double usdToRub) {
        this.usdToRub = usdToRub;
    }

    public double getUsdToByn() {
        return usdToByn;
    }

    public void setUsdToByn(double usdToByn) {
        this.usdToByn = usdToByn;
    }

    public double getUsdToEur() {
        return usdToEur;
    }

    public void setUsdToEur(double usdToEur) {
        this.usdToEur = usdToEur;
    }

    public double getBynToUsd() {
        return bynToUsd;
    }

    public void setBynToUsd(double bynToUsd) {
        this.bynToUsd = bynToUsd;
    }

    public double getBynToRub() {
        return bynToRub;
    }

    public void setBynToRub(double bynToRub) {
        this.bynToRub = bynToRub;
    }

    public double getBynToEur() {
        return bynToEur;
    }

    public void setBynToEur(double bynToEur) {
        this.bynToEur = bynToEur;
    }

    public double getEurToUsd() {
        return eurToUsd;
    }

    public void setEurToUsd(double eurToUsd) {
        this.eurToUsd = eurToUsd;
    }

    public double getEurToRub() {
        return eurToRub;
    }

    public void setEurToRub(double eurToRub) {
        this.eurToRub = eurToRub;
    }

    public double getEurToByn() {
        return eurToByn;
    }

    public void setEurToByn(double eurToByn) {
        this.eurToByn = eurToByn;
    }

    @Override
    public String toString() {
        return "Course1{" +
                "byn=" + byn +
                ", usd=" + usd +
                ", eur=" + eur +
                ", rub=" + rub +
                ", rubToUsd=" + rubToUsd +
                ", rubToByn=" + rubToByn +
                ", rubToEur=" + rubToEur +
                ", usdToRub=" + usdToRub +
                ", usdToByn=" + usdToByn +
                ", usdToEur=" + usdToEur +
                ", bynToUsd=" + bynToUsd +
                ", bynToRub=" + bynToRub +
                ", bynToEur=" + bynToEur +
                ", eurToUsd=" + eurToUsd +
                ", eurToRub=" + eurToRub +
                ", eurToByn=" + eurToByn +
                '}';
    }

}
