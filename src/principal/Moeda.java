package principal;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Date;

public class Moeda implements Serializable {

	private String code;
	private String codein;
	private String name;
	private double high;
	private double low;
	private double varBid;
	private double pctChange;
	private double bid;
	private double ask;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodein() {
		return codein;
	}
	public void setCodein(String codein) {
		this.codein = codein;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getVarBid() {
		return varBid;
	}
	public void setVarBid(double varBid) {
		this.varBid = varBid;
	}
	public double getPctChange() {
		return pctChange;
	}
	public void setPctChange(double pctChange) {
		this.pctChange = pctChange;
	}
	public double getBid() {
		return bid;
	}
	public void setBid(double bid) {
		this.bid = bid;
	}
	public double getAsk() {
		return ask;
	}
	public void setAsk(double ask) {
		this.ask = ask;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome : " +this.name +" Valor bid "+ this.bid;
	}
	
}
