package fehidro.model;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import fehidro.control.ItemRelatorio;

public class Relatorio  {
	
	protected HashMap<Long, ItemRelatorio> itensRelatorio;
	protected List<Long> idsPropostas; //Lista usada para auxiliar na manipulação dos itemRelatorio dentro do mapa. Deve ser igual aos Keys do mapa itensRelatorio.
	
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
		ItemRelatorio[] arr = new ItemRelatorio[itensRelatorio.size()]; //Cria um array
		new LinkedList<ItemRelatorio>(itensRelatorio.values()).toArray(arr); //Transforma a lista em array para uso na classe quicksort
		QuickSort q = new QuickSort();
		q.sort(arr, 0, arr.length-1); //ordena por soma das notas
		for(int i=0;i<arr.length;i++)//atribui a classificacao
		{
			itensRelatorio.get(arr[i].getProposta().getId()).setClassificacao(i+1);
		}
	}
	
	public void setItensRelatorio(List<Avaliacao> avaliacoes)
	{
		Avaliacao avaliacaoAtual;
		Long idPropostaAtual;
		idsPropostas = new LinkedList<>(); //Reset dos ids
		for(int i =0;i<avaliacoes.size();i++)
		{
			avaliacaoAtual = avaliacoes.get(i);
			idPropostaAtual = avaliacaoAtual.getProposta().getId();
			
			if(this.itensRelatorio.get(idPropostaAtual) == null)//Se não existir um itemRelatorio para a proposta nao existir, crie um itemRelatorio
			{
				this.itensRelatorio.put(idPropostaAtual, new ItemRelatorio() );
				this.idsPropostas.add(idPropostaAtual);
			}
			
			this.itensRelatorio.get(idPropostaAtual).addAvaliacao(avaliacaoAtual);//Adicione a avaliacao à proposta
		}
		
		calcularClassificacao();//calcula a classificacao
		
	}
	
	public LinkedList<ItemRelatorio> getItensRelatorio()
	{
		return new LinkedList<ItemRelatorio>(this.itensRelatorio.values());
	}
	
	public LinkedList<ItemRelatorio> getItensRelatorioClassificado()
	{
		LinkedList<ItemRelatorio> classificados = new LinkedList<ItemRelatorio>();
		ItemRelatorio itemAtual;
		for(int i=0;i<this.itensRelatorio.size();i++)//Navegue todos os itens desse relatorio
		{
			itemAtual = itensRelatorio.get(idsPropostas.get(i));
			if(!itemAtual.isDesclassificado())//Se NÃO for desclassificado, adicione
			{
				classificados.add(itemAtual);
			}
		}
		
		return classificados;
	}
	
	public LinkedList<ItemRelatorio> getItensRelatorioDesclassificado()
	{
		LinkedList<ItemRelatorio> desclassificados = new LinkedList<ItemRelatorio>();
		ItemRelatorio itemAtual;
		for(int i=0;i<this.itensRelatorio.size();i++)//Navegue todos os itens desse relatorio
		{
			itemAtual = itensRelatorio.get(idsPropostas.get(i));
			if(itemAtual.isDesclassificado())//Se for desclassificado, adicione
			{
				desclassificados.add(itemAtual);
			}
		}
		
		return desclassificados;
	}
	
}

//Para uso na classificação
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
            int pi = partition(arr, low, high); 
  
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 
}
