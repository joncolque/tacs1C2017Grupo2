package apiResult;

import java.util.ArrayList;
import java.util.List;

import model.Actor;
import model.SummaryActor;

public class ActorListResult {

	private int page;
	private List<SummaryActorResult> results;
	private int total_results;
	private int total_pages;
	
	public List<SummaryActor> toActorList() {
		List<SummaryActor> lista = new ArrayList<SummaryActor>();
		
		results.forEach((a)->lista.add(a.toSumActor()));
		
		return lista;
	}
	
	public ActorListResult() {
		
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<SummaryActorResult> getResults() {
		return results;
	}
	public void setResults(List<SummaryActorResult> results) {
		this.results = results;
	}
	public int getTotal_results() {
		return total_results;
	}
	public void setTotal_results(int total_results) {
		this.total_results = total_results;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}
	
}
