/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesly;

import Dominio.Carro;
import Dominio.Cliente;
import Dominio.Funcionario;
import Dominio.Modelo;
import Dominio.Venda;
import Persistencia.CarroDAO;
import Persistencia.ClienteDAO;
import Persistencia.FuncionarioDAO;
import Persistencia.ModeloDAO;
import Persistencia.VendaDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Enuch
 */
public class FXMLTeslyController implements Initializable {
    
    private ClienteDAO clienteDAO = new ClienteDAO();
    private ObservableList<Cliente> cliente = FXCollections.observableArrayList();
    
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private ObservableList<Funcionario> funcionario = FXCollections.observableArrayList();
    
    private VendaDAO vendaDAO = new VendaDAO();
    private ObservableList<Venda> venda = FXCollections.observableArrayList();
    
    private ModeloDAO modeloDAO = new ModeloDAO();
    private ObservableList<Modelo> modelo = FXCollections.observableArrayList();
    
    private CarroDAO carroDAO = new CarroDAO();
    private ObservableList<Carro> carro = FXCollections.observableArrayList();
    
    @FXML
    private AnchorPane telaClientes, menu, telaFuncionarios, telaVendas, telaModelos, telaCarros;
    // Variaveis de clientes
    @FXML
    private TableView<Cliente> tabela;
    @FXML
    private TableColumn<Cliente, String> nome;
    @FXML
    private TableColumn<Cliente, String> telefone;
    @FXML
    private TableColumn<Cliente, String> email;
    @FXML
    private TableColumn<Cliente, String> cpf;
    @FXML
    private TableColumn<Cliente, String> rua;
    @FXML
    private TableColumn<Cliente, Integer> numero;
    @FXML
    private TableColumn<Cliente, String> bairro;
    @FXML
    private TableColumn<Cliente, String> cidade;
    //Variaveis de Funcionarios
    @FXML
    private TableView<Funcionario> tabelaF;
    @FXML
    private TableColumn<Funcionario, String> nomeF;
    @FXML
    private TableColumn<Funcionario, String> telefoneF;
    @FXML
    private TableColumn<Funcionario, String> emailF;
    @FXML
    private TableColumn<Funcionario, String> cpfF;
    @FXML
    private TableColumn<Funcionario, String> ruaF;
    @FXML
    private TableColumn<Funcionario, Integer> numeroF;
    @FXML
    private TableColumn<Funcionario, String> bairroF;
    @FXML
    private TableColumn<Funcionario, String> cidadeF;
    @FXML
    private TableColumn<Funcionario, Integer> idF;
    @FXML
    private TableColumn<Funcionario, String> dataF;
    //Variaveis de venda
    @FXML
    private TableView<Venda> tabelaV;
    @FXML
    private TableColumn<Venda, Integer> codigoV;
    @FXML
    private TableColumn<Venda, Integer> idFuncionarioV;
    @FXML
    private TableColumn<Venda, Integer> cdCarroV;
    @FXML
    private TableColumn<Venda, String> clienteCpfV;
    @FXML
    private TableColumn<Venda, String> pagamentoV;
    @FXML
    private TableColumn<Venda, String> dataV;
    //Variaveis de modelo
    @FXML
    private TableView<Modelo> tabelaM;
    @FXML
    private TableColumn<Modelo, Integer> modeloId;
    @FXML
    private TableColumn<Modelo, String> nomeModelo;
    //Variaveis de Carros
    @FXML
    private TableView<Carro> tabelaCar;
    @FXML
    private TableColumn<Carro, String> cor;
    @FXML
    private TableColumn<Carro, String> marcha;
    @FXML
    private TableColumn<Carro, String> combustivel;
    @FXML
    private TableColumn<Carro, Integer> portas;
    @FXML
    private TableColumn<Carro, String> ano;
    @FXML
    private TableColumn<Carro, String> chassi;
    @FXML
    private TableColumn<Carro, Float> valor;
    @FXML
    private TableColumn<Carro, Integer> modeloCar;
    @FXML
    private TableColumn<Carro, Integer> idCar;

    
    @FXML
    private TextField txtCPF, txtNome, txtTelefone, txtEmail, txtCpf, txtRua, txtNumero, txtBairro, txtCidade;
    @FXML
    private TextField txtIDF, txtCpfF, txtNomeF, txtTelefoneF, txtEmailF, txtRuaF, txtNumeroF, txtBairroF, txtCidadeF, txtIdF, txtDataF;
    @FXML
    private TextField txtCODIGOV,txtCodigoV, txtIdFuncionarioV, txtCDCarroV, txtClienteCpfV, txtPagamentoV, txtDataV;
    @FXML
    private TextField txtMODELOID, txtModeloId, txtNomeModelo;
    @FXML
    private TextField txtIDCAR, txtCorCar, txtMarchaCar, txtCombustivelCar, txtChassiCar, txtValorCar, txtModeloCar, txtIdCar, txtPortaCar, txtAnoCar;
    @FXML
    private Label lbMensagem, lbMensagemF, lbMensagemV, lbMensagemM, lbMensagemCar;
    @FXML
    private Button btnNew, btnBusca, btnEdit, btnDelete, btnVoltarClientes, btnClientes, btnRelatorioC; 
    @FXML
    private Button btnNewF, btnEditF, btnDeleteF, btnVoltarFuncionarios, btnBuscaF, btnRelatorioF, btnFuncionarios;
    @FXML
    private Button btnNewV, btnEditV, btnDeleteV, btnVoltarVendas, btnBuscaV, btnRelatorioV, btnVendas;
    @FXML
    private Button btnNewM, btnEditM, btnDeleteM, btnVoltarModelos, btnBuscaM, btnRelatorioM, btnModelos;
    @FXML
    private Button btnNewCar, btnEditCar, btnDeleteCar, btnBuscaCar, btnVoltarCarros, btnRelatorioCar, btnCarros;
 
    
    
    
    Cliente c;
    ClienteDAO cDAO = new ClienteDAO();
    
    Funcionario f;
    FuncionarioDAO fDAO = new FuncionarioDAO();
    
    Venda v;
    VendaDAO vDAO = new VendaDAO();
    
    Modelo m;
    ModeloDAO mDAO = new ModeloDAO();
    
    Carro car;
    CarroDAO carDAO = new CarroDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {     
        menu.setVisible(true);
        telaClientes.setVisible(false);
        telaFuncionarios.setVisible(false);
        telaVendas.setVisible(false);
        telaModelos.setVisible(false);
        telaCarros.setVisible(false);
                               
        btnEdit.setDisable(true);
        btnDelete.setDisable(true);
        
    }
    
    //MENU PRINCIPAL
    @FXML
    private void goClientes() {
        menu.setVisible(false);
        telaClientes.setVisible(true);
    }
    
    @FXML
    private void goFuncionarios() {
        menu.setVisible(false);
        telaFuncionarios.setVisible(true);
    }
    
    @FXML
    private void goVendas() {
        menu.setVisible(false);
        telaVendas.setVisible(true);
    }
    @FXML
    private void goModelos() {
        menu.setVisible(false);
        telaModelos.setVisible(true);
    }
    @FXML
    private void goCarros() {
        menu.setVisible(false);
        telaCarros.setVisible(true);
    }
    
    //MENU CLIENTES
    @FXML
    private void backMenuFromClientes(){
        menu.setVisible(true);
        telaClientes.setVisible(false);
    }
    
    @FXML
    private void btnBuscaCliente() {
        if(!txtCPF.getText().equals("")) {
            c = cDAO.buscaCpf(txtCPF.getText());
            lbMensagem.setText("Cliente não encontrado!");
            if(c == null) {
                lbMensagem.setText("Cliente não encontrado!");
            } else {
            lbMensagem.setText("Cliente Localizado!");
            txtNome.setText(c.getNome());
            txtTelefone.setText(c.getTelefone());
            txtEmail.setText(c.getEmail());
            txtCpf.setText(c.getCpf());
            txtRua.setText(c.getRua());
            txtNumero.setText(Integer.toString(c.getNumero()));
            txtBairro.setText(c.getBairro());
            txtCidade.setText(c.getCidade());
            btnEdit.setDisable(false);
            btnDelete.setDisable(false);
            
            }
        }
    }
    
    @FXML
    private void btnIncluiCliente() {

        c.setNome(txtNome.getText());
        c.setTelefone(txtTelefone.getText());
        c.setEmail(txtEmail.getText());
        c.setCpf(txtCpf.getText());
        c.setRua(txtRua.getText());
        c.setNumero(Integer.parseInt(txtNumero.getText()));
        c.setBairro(txtBairro.getText());
        c.setCidade(txtCidade.getText());
        cDAO.incluir(c);
        lbMensagem.setText("Cliente incluido!");
        
        limpaCampos();
        relatorio();   
    }
    
    @FXML
    private void btnEditCliente() {

        c.setNome(txtNome.getText());
        c.setTelefone(txtTelefone.getText());
        c.setEmail(txtEmail.getText());
        c.setCpf(txtCpf.getText());
        c.setRua(txtRua.getText());
        c.setNumero(Integer.parseInt(txtNumero.getText()));
        c.setBairro(txtBairro.getText());
        c.setCidade(txtCidade.getText());
        cDAO.alterar(c, c.getCpf());
        lbMensagem.setText("Cliente alterado!");
        
        limpaCampos();
        relatorio();   
    }
    
    @FXML
    private void btnDeleteCliente() {
        cDAO.excluir(txtCPF.getText());
        lbMensagem.setText("Cliente excluido!");
        
        limpaCampos();
        relatorio();  
    }
    //Limpa as tableviews
    @FXML
    private void limpaCampos() {
        txtNome.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
        txtCpf.setText("");
        txtRua.setText("");
        txtNumero.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
    }
    
    @FXML 
    private void relatorio() {
         nome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        telefone.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));
        email.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
        cpf.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
        rua.setCellValueFactory(new PropertyValueFactory<Cliente, String>("rua"));
        numero.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("numero"));
        bairro.setCellValueFactory(new PropertyValueFactory<Cliente, String>("bairro"));
        cidade.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cidade"));
        
        tabela.getItems().clear();
        
        cliente.addAll(clienteDAO.relatorioGeral());
        tabela.setItems(cliente);
        
        btnEdit.setDisable(true);
        btnDelete.setDisable(true);
    }
    
    //MENU FUNCIONARIOS
    @FXML
    private void backMenuFromFuncionarios(){
        menu.setVisible(true);
        telaFuncionarios.setVisible(false);
    }
    
    @FXML
    private void btnBuscaFuncionarios() {
        if(!txtIDF.getText().equals("")) {
            f = fDAO.relatorioID(Integer.parseInt(txtIDF.getText()));
            if(f == null) {
                lbMensagemF.setText("Funcionario não encontrado!");
            } else {
            lbMensagemF.setText("Funcionario Localizado!");
            txtNomeF.setText(f.getNome());
            txtTelefoneF.setText(f.getTelefone());
            txtEmailF.setText(f.getEmail());
            txtCpfF.setText(f.getCpf());
            txtRuaF.setText(f.getRua());
            txtNumeroF.setText(Integer.toString(f.getNumero()));
            txtBairroF.setText(f.getBairro());
            txtCidadeF.setText(f.getCidade());
            txtIdF.setText(Integer.toString(f.getId()));
            txtDataF.setText(f.getData());
            btnEditF.setDisable(false);
            btnDeleteF.setDisable(false);
            
            }
        }
    }
    
    @FXML
    private void btnIncluiFuncionarios() {

        f.setNome(txtNomeF.getText());
        f.setTelefone(txtTelefoneF.getText());
        f.setEmail(txtEmailF.getText());
        f.setCpf(txtCpfF.getText());
        f.setRua(txtRuaF.getText());
        f.setNumero(Integer.parseInt(txtNumeroF.getText()));
        f.setBairro(txtBairroF.getText());
        f.setCidade(txtCidadeF.getText());
        f.setId(Integer.parseInt(txtIdF.getText()));
        f.setData(txtDataF.getText());
        fDAO.incluir(f);
        lbMensagemF.setText("Funcionario incluido!");
        
        limpaCampos();
        relatorioFuncionarios();   
    }
    
    @FXML
    private void btnEditFuncionarios() {

        f.setNome(txtNomeF.getText());
        f.setTelefone(txtTelefoneF.getText());
        f.setEmail(txtEmailF.getText());
        f.setCpf(txtCpfF.getText());
        f.setRua(txtRuaF.getText());
        f.setNumero(Integer.parseInt(txtNumeroF.getText()));
        f.setBairro(txtBairroF.getText());
        f.setCidade(txtCidadeF.getText());
        f.setId(Integer.parseInt(txtIdF.getText()));
        f.setData(txtDataF.getText());
        fDAO.alterar(f, f.getId());
        lbMensagemF.setText("Funcionario alterado!");
        
        limpaCampos();
        relatorioFuncionarios();   
    }
    
    @FXML
    private void btnDeleteFuncionarios() {
        fDAO.excluir(Integer.parseInt(txtIDF.getText()));
        lbMensagemF.setText("Funcionario excluido!");
        
        limpaCampos();
        relatorioFuncionarios();  
    }
    
    @FXML 
    private void relatorioFuncionarios() {
        idF.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("id"));
        dataF.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("data"));
        nomeF.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
        telefoneF.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("telefone"));
        emailF.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("email"));
        cpfF.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cpf"));
        ruaF.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("rua"));
        numeroF.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("numero"));
        bairroF.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("bairro"));
        cidadeF.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("cidade"));
        
        
        tabelaF.getItems().clear();
        
        funcionario.addAll(funcionarioDAO.relatorioGeral());
        tabelaF.setItems(funcionario);
        
        btnEditF.setDisable(true);
        btnDeleteF.setDisable(true);
    }
    
    //MENU DE VENDAS
    @FXML
    private void backMenuFromVendas(){
        menu.setVisible(true);
        telaVendas.setVisible(false);
    }
    
    @FXML
    private void btnBuscaVendas() {
        if(!txtCODIGOV.getText().equals("")) {
            v = vDAO.buscaCodigo(Integer.parseInt(txtCODIGOV.getText()));
            if(v == null) {
                lbMensagemV.setText("Venda não encontrada!");
            } else {
            lbMensagemV.setText("Venda Localizada!");
            txtCodigoV.setText(Integer.toString(v.getCodigo()));
            txtIdFuncionarioV.setText(Integer.toString(v.getFuncionarioId()));
            txtCDCarroV.setText(Integer.toString(v.getCarroCodigo()));
            txtClienteCpfV.setText(v.getClienteCpf());
            txtPagamentoV.setText(v.getPagamento());
            txtDataV.setText(v.getData());
            btnEditV.setDisable(false);
            btnDeleteV.setDisable(false);
                        
            }
        }
    }
    
    @FXML
    private void btnIncluiVendas() {

        v.setCodigo(Integer.parseInt(txtCodigoV.getText()));
        v.setFuncionarioId(Integer.parseInt(txtIdFuncionarioV.getText()));
        v.setCarroCodigo(Integer.parseInt(txtCDCarroV.getText()));
        v.setClientCpf(txtClienteCpfV.getText());
        v.setPagamento(txtPagamentoV.getText());
        v.setData(txtDataV.getText());
        
        
        vDAO.incluir(v);
        lbMensagemV.setText("Venda incluido!");
        
        limpaCampos();
        relatorioVendas();   
    }
    
    @FXML
    private void btnEditVendas() {

        v.setCodigo(Integer.parseInt(txtCodigoV.getText()));
        v.setFuncionarioId(Integer.parseInt(txtIdFuncionarioV.getText()));
        v.setCarroCodigo(Integer.parseInt(txtCDCarroV.getText()));
        v.setClientCpf(txtClienteCpfV.getText());
        v.setPagamento(txtPagamentoV.getText());
        v.setData(txtDataV.getText());
        vDAO.alterar(v, v.getCodigo());
        lbMensagemV.setText("Venda alterado!");
        
        limpaCampos();
        relatorioVendas();   
    }
    
    @FXML
    private void btnDeleteVendas() {
        vDAO.excluir(Integer.parseInt(txtCODIGOV.getText()));
        lbMensagemV.setText("Venda excluido!");
        
        limpaCampos();
        relatorioVendas();  
    }
    
    @FXML 
    private void relatorioVendas() {
        codigoV.setCellValueFactory(new PropertyValueFactory<Venda, Integer>("codigo"));
        idFuncionarioV.setCellValueFactory(new PropertyValueFactory<Venda, Integer>("funcionarioId"));
        cdCarroV.setCellValueFactory(new PropertyValueFactory<Venda, Integer>("carroCodigo"));
        clienteCpfV.setCellValueFactory(new PropertyValueFactory<Venda, String>("clienteCpf"));
        pagamentoV.setCellValueFactory(new PropertyValueFactory<Venda, String>("pagamento"));
        dataV.setCellValueFactory(new PropertyValueFactory<Venda, String>("data"));
       
        
        
        tabelaV.getItems().clear();
        
        venda.addAll(vendaDAO.relatorioGeral());
        tabelaV.setItems(venda);
        
        btnEditV.setDisable(true);
        btnDeleteV.setDisable(true);
    }
    
    //MENU MODELOS
    @FXML
    private void backMenuFromModelos(){
        menu.setVisible(true);
        telaModelos.setVisible(false);
    }
    
    @FXML
    private void btnBuscaModelos() {
        if(!txtMODELOID.getText().equals("")) {
            m = mDAO.relatorioId(Integer.parseInt(txtMODELOID.getText()));
            if(m == null) {
                lbMensagemM.setText("Modelo não encontrada!");
            } else {
            lbMensagemV.setText("Venda Localizada!");
            txtModeloId.setText(Integer.toString(m.getModeloId()));
            txtNomeModelo.setText(m.getNomeModelo());
            btnEditM.setDisable(false);
            btnDeleteM.setDisable(false);
                        
            }
        }
    }
    
    @FXML
    private void btnIncluiModelos() {

        m.setModeloId(Integer.parseInt(txtModeloId.getText()));
        m.setNomeModelo(txtNomeModelo.getText());
                
        mDAO.incluir(m);
        lbMensagemM.setText("Modelo incluido!");
        
        limpaCampos();
        relatorioModelos();   
    }
    
    @FXML
    private void btnEditModelos() {

        m.setModeloId(Integer.parseInt(txtModeloId.getText()));
        m.setNomeModelo(txtNomeModelo.getText());
        
        mDAO.alterar(m, m.getModeloId());
        lbMensagemM.setText("Modelo alterado!");
        
        limpaCampos();
        relatorioModelos();   
    }
    
    @FXML
    private void btnDeleteModelos() {
        mDAO.excluir(Integer.parseInt(txtMODELOID.getText()));
        lbMensagemM.setText("Modelo excluido!");
        
        limpaCampos();
        relatorioModelos();  
    }
    
    @FXML 
    private void relatorioModelos() {
        modeloId.setCellValueFactory(new PropertyValueFactory<Modelo, Integer>("modeloId"));
        nomeModelo.setCellValueFactory(new PropertyValueFactory<Modelo, String>("nomeModelo"));
       
        
        
        tabelaM.getItems().clear();
        
        modelo.addAll(modeloDAO.relatorioGeral());
        tabelaM.setItems(modelo);
        
        btnEditM.setDisable(true);
        btnDeleteM.setDisable(true);
    }
    
    //MENU CARROS
    @FXML
    private void backMenuFromCarros(){
        menu.setVisible(true);
        telaCarros.setVisible(false);
    }
    
    @FXML
    private void btnBuscaCarros() {
        if(!txtIDCAR.getText().equals("")) {
            car = carDAO.buscaId(Integer.parseInt(txtIDCAR.getText()));
            if(car == null) {
                lbMensagemCar.setText("Carro não encontrado!");
            } else {
            lbMensagemCar.setText("Carro Localizado!");
            txtCorCar.setText(car.getCor());
            txtMarchaCar.setText(car.getMarcha());
            txtCombustivelCar.setText(car.getCombustivel());
            txtPortaCar.setText(Integer.toString(car.getNumeroPortas()));
            txtAnoCar.setText(car.getAno());
            txtChassiCar.setText(car.getChassi());
            txtValorCar.setText(Float.toString(car.getValor()));
            txtModeloCar.setText(Integer.toString(car.getModeloId()));
            txtIdCar.setText(Integer.toString(car.getId()));
            btnEditCar.setDisable(false);
            btnDeleteCar.setDisable(false);
            
            }
        }
    }
    
    @FXML
    private void btnIncluiCarros() {

        car.setCor(txtCorCar.getText());
        car.setMarcha(txtMarchaCar.getText());
        car.setCombustivel(txtCombustivelCar.getText());
        car.setNumeroPortas(Integer.parseInt(txtPortaCar.getText()));
        car.setAno(txtAnoCar.getText());
        car.setChassi(txtChassiCar.getText());
        car.setValor(Float.parseFloat(txtValorCar.getText()));
        car.setModeloId(Integer.parseInt(txtModeloCar.getText()));
        car.setId(Integer.parseInt(txtIdCar.getText()));
        carDAO.incluir(car);
        lbMensagemCar.setText("Carro incluido!");
        
        limpaCampos();
        relatorioCarros();   
    }
    
    @FXML
    private void btnEditCarros() {

        car.setCor(txtCorCar.getText());
        car.setMarcha(txtMarchaCar.getText());
        car.setCombustivel(txtCombustivelCar.getText());
        car.setNumeroPortas(Integer.parseInt(txtPortaCar.getText()));
        car.setAno(txtAnoCar.getText());
        car.setChassi(txtChassiCar.getText());
        car.setValor(Float.parseFloat(txtValorCar.getText()));
        car.setModeloId(Integer.parseInt(txtModeloCar.getText()));
        car.setId(Integer.parseInt(txtIdCar.getText()));
        carDAO.alterar(car, car.getId());
        lbMensagemCar.setText("Carro alterado!");
        
        limpaCampos();
        relatorioCarros();   
    }
    
    @FXML
    private void btnDeleteCarros() {
        carDAO.excluir(Integer.parseInt(txtIDCAR.getText()));
        lbMensagemCar.setText("Carro excluido!");
        
        limpaCampos();
        relatorioCarros();  
    }
    
    @FXML 
    private void relatorioCarros() {
        cor.setCellValueFactory(new PropertyValueFactory<Carro, String>("cor"));
        marcha.setCellValueFactory(new PropertyValueFactory<Carro, String>("marcha"));
        combustivel.setCellValueFactory(new PropertyValueFactory<Carro, String>("combustivel"));
        portas.setCellValueFactory(new PropertyValueFactory<Carro, Integer>("numeroPortas"));
        ano.setCellValueFactory(new PropertyValueFactory<Carro, String>("ano"));
        chassi.setCellValueFactory(new PropertyValueFactory<Carro, String>("chassi"));
        valor.setCellValueFactory(new PropertyValueFactory<Carro, Float>("valor"));
        modeloCar.setCellValueFactory(new PropertyValueFactory<Carro, Integer>("modeloId"));
        idCar.setCellValueFactory(new PropertyValueFactory<Carro, Integer>("id"));
       
        
        
        tabelaCar.getItems().clear();
        
        carro.addAll(carroDAO.relatorioGeral());
        tabelaCar.setItems(carro);
        
        btnEditCar.setDisable(true);
        btnDeleteCar.setDisable(true);
    }
    
}
