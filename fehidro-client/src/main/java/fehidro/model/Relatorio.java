package fehidro.model;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import fehidro.control.ItemRelatorio;

class QuickSort 
{ 
    int partition(ItemRelatorio arr[], int low, int high) 
    { 
        ItemRelatorio pivot = arr[high];  
        int i = (low-1);
        for (int j=low; j<high; j++) 
        { 
            if (arr[j].getSoma() <= pivot.getSoma()) 
            { 
                i++; 
  
                ItemRelatorio temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        ItemRelatorio temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
    void sort(ItemRelatorio arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
}

public class Relatorio  {
	
	protected HashMap<Long, ItemRelatorio> itensRelatorio;
	protected List<Long> idsPropostas;
	
	//Construtores
	public Relatorio()
	{
		itensRelatorio = new HashMap<Long, ItemRelatorio>();
	}
	
	public Relatorio(List<Avaliacao> avaliacoes)
	{
		setItensRelatorio(avaliacoes);
	}
	
	//Metodos
	
	public void calcularClassificacao() {
		QuickSort q = new QuickSort();
		ItemRelatorio[] arr = new ItemRelatorio[itensRelatorio.size()];
		new LinkedList<ItemRelatorio>(itensRelatorio.values()).toArray(arr);
		q.sort(arr, 0, arr.length-1);
		for(int i=0;i<arr.length;i++)
		{
			itensRelatorio.get(arr[i].getProposta().getId()).setClassificacao(i+1);
		}
	}
	
	public void setItensRelatorio(List<Avaliacao> avaliacoes)
	{
		Avaliacao avaliacaoAtual;
		Long idPropostaAtual;
		idsPropostas = new LinkedList<>(); //Reset
		for(int i =0;i<avaliacoes.size();i++)
		{
			avaliacaoAtual = avaliacoes.get(i);
			idPropostaAtual = avaliacaoAtual.getProposta().getId();
			
			if(this.itensRelatorio.get(idPropostaAtual) == null)
			{
				this.itensRelatorio.put(idPropostaAtual, new ItemRelatorio() );
				this.idsPropostas.add(idPropostaAtual);
			}
			
			this.itensRelatorio.get(idPropostaAtual).addAvaliacao(avaliacaoAtual);
		}
		
		calcularClassificacao();
		
	}
	
	public LinkedList<ItemRelatorio> getItensRelatorio()
	{
		return new LinkedList<ItemRelatorio>(this.itensRelatorio.values());
	}
	
	
}
