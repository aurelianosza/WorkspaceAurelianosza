package Projeto;

import java.util.Calendar;
import ListaDuplamente.Lista;;

public class DocumentoDeProcesso {

	public enum TipoDaEncomendaEnum {
		SIMPLES, EXPRESSA;

	}

	private static int contadorDoCodigo = 0;
	private static int dia = 0;

	private static void gerenciaDia() {
		if (dia != Calendar.DAY_OF_MONTH) {
			contadorDoCodigo = 0;
			dia = Calendar.DAY_OF_MONTH;
		}
	}

	private String codigoIdentificador;
	private int prioridade;
	private Pessoa comprador;
	private Pessoa vendedor;
	private Pessoa transportador;
	private float peso;
	private TipoDaEncomendaEnum tipoDaEncomenda;
	private Lista listaDeObservacoes;

	public DocumentoDeProcesso(String codigo, Pessoa vendedor, Pessoa comprador, float peso, TipoDaEncomendaEnum tipo,
			Lista listaDeObservacoes) {
		this.setCodigoIdentificador(codigo);
		this.setVendedor(vendedor);
		this.setComprador(comprador);
		this.setPeso(peso);
		this.setTipoDaEncomenda(tipo);
		this.setListaDeObservacoes(listaDeObservacoes);
	}

	public static String geraCodigo() {
		String codigo = "";
		codigo = codigo + Calendar.YEAR;
		codigo = codigo + Calendar.MONTH + 1;
		codigo = codigo + Calendar.DAY_OF_MONTH;
		gerenciaDia();
		if (contadorDoCodigo < 9)
			codigo += "0000";
		else if (contadorDoCodigo >= 10 && contadorDoCodigo <= 99)
			codigo += "000";
		else if (contadorDoCodigo >= 100 && contadorDoCodigo <= 999)
			codigo += "00";
		else if (contadorDoCodigo >= 1000 && contadorDoCodigo < 9999)
			codigo += "0";
		codigo = codigo + contadorDoCodigo;
		contadorDoCodigo++;
		return codigo;
	}

	public Lista getListaDeObservacoes() {
		return this.listaDeObservacoes;
	}

	public void setListaDeObservacoes(Lista lista) {
		this.listaDeObservacoes = lista;
	}

	public String getCodigoIdentificador() {
		return codigoIdentificador;
	}

	private void setCodigoIdentificador(String codigoIdentificador) {
		if (codigoIdentificador != null)
			this.codigoIdentificador = codigoIdentificador;
		else
			this.codigoIdentificador = "";
	}

	public int getPrioridade() {
		return prioridade;
	}

	private void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public Pessoa getComprador() {
		return comprador;
	}

	private void setComprador(Pessoa comprador) {
		if (comprador != null)
			this.comprador = comprador;
	}

	public Pessoa getVendedor() {
		return vendedor;
	}

	private void setVendedor(Pessoa vendedor) {
		if (vendedor != null)
			this.vendedor = vendedor;
	}

	public Pessoa getTransportador() {
		return transportador;
	}

	private void setTransportador(Pessoa transportador) {
		if (transportador != null)
			this.transportador = transportador;
	}

	public float getPeso() {
		return peso;
	}

	private void setPeso(float peso) {
		if (peso > 0)
			this.peso = peso;
	}

	public TipoDaEncomendaEnum getTipoDaEncomenda() {
		return tipoDaEncomenda;
	}

	public void setTipoDaEncomenda(TipoDaEncomendaEnum tipoDaEncomenda) {
		this.tipoDaEncomenda = tipoDaEncomenda;
	}

	public Lista getDetalhesDaEncomenda() {
		return this.listaDeObservacoes;
	}

	public void setDetalhesDaEncomenda(String detalhesDaEncomenda) {
		this.getDetalhesDaEncomenda().adicionaInicio(detalhesDaEncomenda);
	}

	@Override
	public String toString() {
		return this.getCodigoIdentificador() + "  de " + this.getVendedor().getNome() + " para "
				+ this.getComprador().getNome() + " Encomenda : "
				+ (this.getTipoDaEncomenda() == TipoDaEncomendaEnum.SIMPLES ? "Simples" : "Expressa");
	}
}