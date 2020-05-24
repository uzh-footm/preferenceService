package com.footm.preferenceservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * The class PlayerPositions is a JavaBean objects used to serialize and deserialize JSON request and response object by Jackson.
 *
 * @author Rinor Sefa
 * @author Lundrim Azemi
 */
public class PlayerPositions {
    private int ls, st, rs, lw, lf, cf, rf, rw, lam, cam, ram, lm, lcm,
            cm, rcm, rm, lwb, ldm, cdm, rdm, rwb, lb, lcb, cb, rcb, rb, gk;

    public PlayerPositions() {
    }


    public PlayerPositions(int ls, int st, int rs, int lw, int lf, int cf,
                           int rf, int rw, int lam, int cam, int ram, int lm, int lcm,
                           int cm, int rcm, int rm, int lwb, int ldm, int cdm, int rdm,
                           int rwb, int lb, int lcb, int cb, int rcb, int rb, int gk) {
        this.ls = ls;
        this.st = st;
        this.rs = rs;
        this.lw = lw;
        this.lf = lf;
        this.cf = cf;
        this.rf = rf;
        this.rw = rw;
        this.lam = lam;
        this.cam = cam;
        this.ram = ram;
        this.lm = lm;
        this.lcm = lcm;
        this.cm = cm;
        this.rcm = rcm;
        this.rm = rm;
        this.lwb = lwb;
        this.ldm = ldm;
        this.cdm = cdm;
        this.rdm = rdm;
        this.rwb = rwb;
        this.lb = lb;
        this.lcb = lcb;
        this.cb = cb;
        this.rcb = rcb;
        this.rb = rb;
        this.gk = gk;
    }

    @JsonProperty
    public int getLs() {
        return ls;
    }

    @JsonProperty
    public void setLs(int ls) {
        this.ls = ls;
    }

    @JsonProperty
    public int getSt() {
        return st;
    }

    @JsonProperty
    public void setSt(int st) {
        this.st = st;
    }

    @JsonProperty
    public int getRs() {
        return rs;
    }

    @JsonProperty
    public void setRs(int rs) {
        this.rs = rs;
    }

    @JsonProperty
    public int getLw() {
        return lw;
    }

    @JsonProperty
    public void setLw(int lw) {
        this.lw = lw;
    }

    @JsonProperty
    public int getLf() {
        return lf;
    }

    @JsonProperty
    public void setLf(int lf) {
        this.lf = lf;
    }

    @JsonProperty
    public int getCf() {
        return cf;
    }

    @JsonProperty
    public void setCf(int cf) {
        this.cf = cf;
    }

    @JsonProperty
    public int getRf() {
        return rf;
    }

    @JsonProperty
    public void setRf(int rf) {
        this.rf = rf;
    }

    @JsonProperty
    public int getRw() {
        return rw;
    }

    @JsonProperty
    public void setRw(int rw) {
        this.rw = rw;
    }

    @JsonProperty
    public int getLam() {
        return lam;
    }

    @JsonProperty
    public void setLam(int lam) {
        this.lam = lam;
    }

    @JsonProperty
    public int getCam() {
        return cam;
    }

    @JsonProperty
    public void setCam(int cam) {
        this.cam = cam;
    }

    @JsonProperty
    public int getRam() {
        return ram;
    }

    @JsonProperty
    public void setRam(int ram) {
        this.ram = ram;
    }

    @JsonProperty
    public int getLm() {
        return lm;
    }

    @JsonProperty
    public void setLm(int lm) {
        this.lm = lm;
    }

    @JsonProperty
    public int getLcm() {
        return lcm;
    }

    @JsonProperty
    public void setLcm(int lcm) {
        this.lcm = lcm;
    }

    @JsonProperty
    public int getCm() {
        return cm;
    }

    @JsonProperty
    public void setCm(int cm) {
        this.cm = cm;
    }

    @JsonProperty
    public int getRcm() {
        return rcm;
    }

    @JsonProperty
    public void setRcm(int rcm) {
        this.rcm = rcm;
    }

    @JsonProperty
    public int getRm() {
        return rm;
    }

    @JsonProperty
    public void setRm(int rm) {
        this.rm = rm;
    }

    @JsonProperty
    public int getLwb() {
        return lwb;
    }

    @JsonProperty
    public void setLwb(int lwb) {
        this.lwb = lwb;
    }

    @JsonProperty
    public int getLdm() {
        return ldm;
    }

    @JsonProperty
    public void setLdm(int ldm) {
        this.ldm = ldm;
    }

    @JsonProperty
    public int getCdm() {
        return cdm;
    }

    @JsonProperty
    public void setCdm(int cdm) {
        this.cdm = cdm;
    }

    @JsonProperty
    public int getRdm() {
        return rdm;
    }

    @JsonProperty
    public void setRdm(int rdm) {
        this.rdm = rdm;
    }

    @JsonProperty
    public int getRwb() {
        return rwb;
    }

    @JsonProperty
    public void setRwb(int rwb) {
        this.rwb = rwb;
    }

    @JsonProperty
    public int getLb() {
        return lb;
    }

    @JsonProperty
    public void setLb(int lb) {
        this.lb = lb;
    }

    @JsonProperty
    public int getLcb() {
        return lcb;
    }

    @JsonProperty
    public void setLcb(int lcb) {
        this.lcb = lcb;
    }

    @JsonProperty
    public int getCb() {
        return cb;
    }

    @JsonProperty
    public void setCb(int cb) {
        this.cb = cb;
    }

    @JsonProperty
    public int getRcb() {
        return rcb;
    }

    @JsonProperty
    public void setRcb(int rcb) {
        this.rcb = rcb;
    }

    @JsonProperty
    public int getRb() {
        return rb;
    }

    @JsonProperty
    public void setRb(int rb) {
        this.rb = rb;
    }

    @JsonProperty
    public int getGk() {
        return gk;
    }

    @JsonProperty
    public void setGk(int gk) {
        this.gk = gk;
    }

    @Override
    public String toString() {
        return "PlayerPositions{" +
                "ls=" + ls +
                ", st=" + st +
                ", rs=" + rs +
                ", lw=" + lw +
                ", lf=" + lf +
                ", cf=" + cf +
                ", rf=" + rf +
                ", rw=" + rw +
                ", lam=" + lam +
                ", cam=" + cam +
                ", ram=" + ram +
                ", lm=" + lm +
                ", lcm=" + lcm +
                ", cm=" + cm +
                ", rcm=" + rcm +
                ", rm=" + rm +
                ", lwb=" + lwb +
                ", ldm=" + ldm +
                ", cdm=" + cdm +
                ", rdm=" + rdm +
                ", rwb=" + rwb +
                ", lb=" + lb +
                ", lcb=" + lcb +
                ", cb=" + cb +
                ", rcb=" + rcb +
                ", rb=" + rb +
                ", gk=" + gk +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerPositions that = (PlayerPositions) o;
        return ls == that.ls &&
                st == that.st &&
                rs == that.rs &&
                lw == that.lw &&
                lf == that.lf &&
                cf == that.cf &&
                rf == that.rf &&
                rw == that.rw &&
                lam == that.lam &&
                cam == that.cam &&
                ram == that.ram &&
                lm == that.lm &&
                lcm == that.lcm &&
                cm == that.cm &&
                rcm == that.rcm &&
                rm == that.rm &&
                lwb == that.lwb &&
                ldm == that.ldm &&
                cdm == that.cdm &&
                rdm == that.rdm &&
                rwb == that.rwb &&
                lb == that.lb &&
                lcb == that.lcb &&
                cb == that.cb &&
                rcb == that.rcb &&
                rb == that.rb &&
                gk == that.gk;
    }

    @Override
    public int hashCode() {

        return Objects.hash(ls, st, rs, lw, lf, cf, rf, rw, lam, cam, ram, lm, lcm, cm, rcm, rm, lwb, ldm, cdm, rdm, rwb, lb, lcb, cb, rcb, rb, gk);
    }
}
