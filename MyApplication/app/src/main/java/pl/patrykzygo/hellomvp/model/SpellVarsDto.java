package pl.patrykzygo.hellomvp.model;


import java.util.List;

public class SpellVarsDto {

    private String ranksWith;
    private String dyn;
    private String link;
    private List<Double> coeff;
    private String key;

    public String getRanksWith() {
        return ranksWith;
    }

    public void setRanksWith(String ranksWith) {
        this.ranksWith = ranksWith;
    }

    public String getDyn() {
        return dyn;
    }

    public void setDyn(String dyn) {
        this.dyn = dyn;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Double> getCoeff() {
        return coeff;
    }

    public void setCoeff(List<Double> coeff) {
        this.coeff = coeff;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
