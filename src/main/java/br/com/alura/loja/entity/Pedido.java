package br.com.alura.loja.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate data = LocalDate.now();

	
	// POR PADR�O OS RELACIONAMENTOS "ToOne" S�O EAGER E ISSO PODE GERAR PROBLEMA DE PERFORMANCE NAS CONSULTAS
	// OS RELACIONAMENTOS "ToMany" S�O LAZI POR PADR�O
	// UMA BOA PRATICA � ALTERAR RELACIONAMENTOS TOONE PARA "LAZE"
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;

	// CASO A ANOTA��O @Column SEJA CRIADA DEPOIS DA CRIA��O DA TABELA, NO MOMENTO
	// DE EXECU��O SERA CRIADA UMA NOVA COLUNA NA TABELAS
	@Column(name = "valor_total")
	private BigDecimal valorTotal;

	// NO CASO DE item_pedido, � DEPENDENTE DE pedido
	// ENT�O, USANDO CASCADE TUDO QUE ACONTECER COM PEDIDO VAI ACONTECER COM
	// ITEM_PEDIDO TAMBEM
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();

	@Deprecated
	public Pedido() {

	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	// LEMBRAR SEMPRE NO RELACIONAMENTO BIDIRECIONAL DE FAZER AS ENTIDADES SE
	// CONHECEREM
	public void adicionaItem(ItemPedido item) {
		item.setPedido(this);
		this.itens.add(item);
		this.valorTotal = new BigDecimal(item.getQuantidade()).multiply(item.getValorUnitario());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getPreco() {
		return valorTotal;
	}

	public void setPreco(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
