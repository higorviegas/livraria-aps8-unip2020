package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Autor;
import model.Editora;
import model.Livro;

public class View extends JFrame{

	private static final long serialVersionUID = 1L;
	
	//COMPONENTES
    //LISTAR
    JButton listarLivroBtn, listarAutorBtn, listarEditoraBtn, buscaLivroBtn, buscaAutorBtn, buscaEditoraBtn;
    JTextField buscaLivroField, buscaAutorField, buscaEditoraField;
    JComboBox buscaLivroCombo;
    JTable livroTable, autorTable, editoraTable;
    JScrollPane livroScrollPane, autorScrollPane, editoraScrollPane;
    JPanel buscaLivroPanel, livroTablePanel, buscaAutorPanel, autorTablePanel, buscaEditoraPanel, editoraTablePanel;
    JPanel listarLivroPanel, listarAutorPanel, listarEditoraPanel;
    CardLayout listarCardLayout;
    
    //ADICIONAR
    JButton adicionarLivroBtn, adicionaAutorBtn, adicionarEditoraBtn, maisAddBtn, menosAddBtn;
    JButton adicionarLivroSalvarBtn, adicionarAutorSalvarBtn, adicionarEditoraSalvarBtn, adicionarAutorBtn;
    JLabel livroTituloLabel, livroIsbnLabel, livroAutorLabel, addLivroAutoresLabel, livroPrecoLabel, livroEditoraLabel;
    JLabel autorNomeLabel, autorSobrenomeLabel, editoraNomeLabel, editoraUrlLabel, addLivroAutoresField;
    JTextField livroTituloField, livroIsbnField, livroPrecoField, autorNomeField, autorSobrenomeField, editoraNomeField;
    JTextField editoraUrlField;
    JPanel addLivroTituloPanel, addLivroIsbnPanel, addLivroAutorPanel, addLivroAutoresPanel, addLivroPrecoPanel;
    JPanel addLivroEditoraPanel, addLivroBtnPanel, addAutorNomePanel, addAutorSobrenomePanel, addAutorBtnPanel;
    JPanel addEditoraBtnPanel, adicionarLivroPanel, adicionarAutorPanel, adicionarEditoraPanel, addEditoraNomePanel, addEditoraUrlPanel;
    JComboBox livroAutorCombo, livroEditoraCombo;
    CardLayout adicionarCardLayout;
    
    //EDITAR
    JButton editarLivroBtn, editarAutorBtn, editarEditoraBtn, menosEdtBtn, maisEdtBtn, editarLivroSalvarBtn, editarLivroBuscarBtn;
    JButton editarAutorSalvarBtn, editarAutorBuscarBtn, editarEditoraSalvarBtn, editarEditoraBuscarBtn;
    JLabel editarLivroIsbnLabel, editarLivroTituloLabel, editarLivroAutorLabel, edtLivroAutorLabel, edtLivroNAutorLabel;
    JLabel editarLivroPrecoLabel, editarLivroEditoraLabel, edtLivroEditoraComboLabel, editarAutorIdLabel, editarAutorNomeLabel;
    JLabel editarAutorSobrenomeLabel, editarEditoraIdLabel, editarEditoraNomeLabel, editarEditoraUrlLabel, editarLivroEditoraField;
    JComboBox edtLivroIsbnCombo, edtLivroNAutorCombo, editarLivroEditoraCombo, edtAutorIdCombo, edtEditoraIdCombo;
    JPanel edtLivroIsbnPanel, edtLivroTituloPanel, edtLivroAutorPanel, edtLivroNAutorPanel, edtLivroPrecoPanel, edtLivroEditoraPanel;
    JPanel edtLivroEditoraComboPanel, edtLivroBtnPanel, edtAutorIdPanel, edtAutorNomePanel, edtAutorSobrenomePanel, edtAutorBtnPanel;
    JPanel edtEditoraIdPanel, edtEditoraNomePanel, edtEditoraUrlPanel, edtEditoraBtnPanel;
    JPanel editarLivroPanel, editarAutorPanel, editarEditoraPanel;
    JTextField editarLivroTituloField, editarLivroPrecoField, editarAutorNomeField, editarAutorSobrenomeField;
    JTextField editarEditoraNomeField, editarEditoraUrlField;
    CardLayout editarCardLayout;
    
    //EXCLUIR
    JButton excluirLivroBtn, excluirAutorBtn, excluirEditoraBtn, excluirLivroExcluirBtn, excluirLivroBuscarBtn;
    JButton excluirAutorExcluirBtn, excluirAutorBuscarBtn, excluirEditoraExcluirBtn, excluirEditoraBuscarBtn;
    JLabel excluirLivroIsbnLabel, excluirLivroTituloLabel, excluirLivroAutorLabel, excluirLivroPrecoLabel, excluirLivroEditoraLabel;
    JLabel excluirAutorIdLabel, excluirAutorNomeLabel, excluirAutorSobrenomeLabel, excluirEditoraIdLabel, excluirEditoraNomeLabel;
    JLabel excluirEditoraUrlLabel, excluirAutorNomeField, excluirAutorSobrenomeField, excluirEditoraNomeField, excluirEditoraUrlField;
    JComboBox excLivroIsbnCombo, excAutorIdCombo, excEditoraIdCombo;
    JPanel excLivroIsbnPanel, excLivroTituloPanel, excLivroAutorPanel, excLivroPrecoPanel, excLivroEditoraPanel, excLivroBtnPanel;
    JPanel excAutorIdPanel, excAutorNomePanel, excAutorSobrenomePanel, excAutorBtnPanel, excEditoraIdPanel, excEditoraNomePanel;
    JPanel excEditoraUrlPanel, excEditoraBtnPanel, excluirLivroPanel, excluirAutorPanel, excluirEditoraPanel;
    JLabel excluirLivroTituloField, excluirLivroAutorField, excluirLivroPrecoField, excluirLivroEditoraField;
    CardLayout excluirCardLayout;    
    
    //GERAL
    JPanel listarHeaderPanel, adicionarHeaderPanel, editarHeaderPanel, excluirHeaderPanel;
    JPanel listarCardPanel, adicionarCardPanel, editarCardPanel, excluirCardPanel;
    JButton listarBtn, adicionarBtn, editarBtn, excluirBtn;
    JPanel listarContent, adicionarContent, editarContent, excluirContent;
    JPanel contentPanel, acoesFooterPanel;
    CardLayout livroCardLayout, autorCardLayout, editoraCardLayout;
    CardLayout cardLayout;  
    DefaultTableModel livroModel, autorModel, editoraModel;
    
    public View(){
        super(); 
    }
    
    void criaTabela(){       
        livroModel = new DefaultTableModel();
        livroModel.addColumn("ISBN");
        livroModel.addColumn("Titulo");
        livroModel.addColumn("Autor");
        livroModel.addColumn("Editora");
        livroModel.addColumn("Preco");        
                
        autorModel = new DefaultTableModel();
        autorModel.addColumn("ID");
        autorModel.addColumn("Nome");
        autorModel.addColumn("Sobrenome");
        
        editoraModel = new DefaultTableModel();
        editoraModel.addColumn("ID");
        editoraModel.addColumn("Nome");
        editoraModel.addColumn("Site");      
    }        
    
    public void criaJanela(){
        criaTabela();       
        
        //LISTAR                
        listarHeaderPanel = new JPanel();
        listarLivroBtn = new JButton("Livros");
        listarAutorBtn = new JButton("Autores");
        listarEditoraBtn = new JButton("Editora");
        listarHeaderPanel.add(listarLivroBtn);
        listarHeaderPanel.add(listarAutorBtn);
        listarHeaderPanel.add(listarEditoraBtn);   
        listarLivroBtn.setEnabled(false);
        
        listarLivroPanel = new JPanel();
        listarLivroPanel.setLayout(new BorderLayout());
        buscaLivroPanel = new JPanel();
        buscaLivroField = new JTextField(20);
        buscaLivroBtn = new JButton("Buscar");
        buscaLivroCombo = new JComboBox();
        buscaLivroCombo.addItem("por Titulo");
        buscaLivroCombo.addItem("por Autor");
        buscaLivroCombo.addItem("por Editora");
        buscaLivroPanel.add(buscaLivroField);
        buscaLivroPanel.add(buscaLivroCombo);
        buscaLivroPanel.add(buscaLivroBtn);
        livroTablePanel = new JPanel();
        livroTablePanel.setLayout(new BorderLayout());
        livroTable = new JTable(livroModel);
        livroScrollPane = new JScrollPane(livroTable);
        livroTablePanel.add(livroScrollPane, BorderLayout.CENTER);
        listarLivroPanel.add(buscaLivroPanel, BorderLayout.NORTH);
        listarLivroPanel.add(livroTablePanel, BorderLayout.CENTER);

        listarAutorPanel = new JPanel();
        listarAutorPanel.setLayout(new BorderLayout());
        buscaAutorPanel = new JPanel();
        buscaAutorField = new JTextField(20);
        buscaAutorBtn = new JButton("Buscar");
        buscaAutorPanel.add(buscaAutorField);
        buscaAutorPanel.add(buscaAutorBtn);
        autorTablePanel = new JPanel();
        autorTablePanel.setLayout(new BorderLayout());
        autorTable = new JTable(autorModel);
        autorScrollPane = new JScrollPane(autorTable);
        autorTablePanel.add(autorScrollPane, BorderLayout.CENTER);
        listarAutorPanel.add(buscaAutorPanel, BorderLayout.NORTH);
        listarAutorPanel.add(autorTablePanel, BorderLayout.CENTER); 
        
        listarEditoraPanel = new JPanel();
        listarEditoraPanel.setLayout(new BorderLayout());
        buscaEditoraPanel = new JPanel();
        buscaEditoraField = new JTextField(20);
        buscaEditoraBtn = new JButton("Buscar");
        buscaEditoraPanel.add(buscaEditoraField);
        buscaEditoraPanel.add(buscaEditoraBtn);
        editoraTablePanel = new JPanel();
        editoraTablePanel.setLayout(new BorderLayout());
        editoraTable = new JTable(editoraModel);
        editoraScrollPane = new JScrollPane(editoraTable);
        editoraTablePanel.add(editoraScrollPane, BorderLayout.CENTER);
        listarEditoraPanel.add(buscaEditoraPanel, BorderLayout.NORTH);
        listarEditoraPanel.add(editoraTablePanel, BorderLayout.CENTER);
        
        listarCardPanel = new JPanel();
        listarCardLayout = new CardLayout();
        listarCardPanel.setLayout(listarCardLayout);
        listarCardPanel.add("listarLivroPanel", listarLivroPanel);
        listarCardPanel.add("listarAutorPanel", listarAutorPanel);
        listarCardPanel.add("listarEditoraPanel", listarEditoraPanel);
        
        //ADICIONAR
        adicionarHeaderPanel = new JPanel();
        adicionarLivroBtn = new JButton("Livros");
        adicionarAutorBtn = new JButton("Autores");
        adicionarEditoraBtn = new JButton("Editora");
        adicionarHeaderPanel.add(adicionarLivroBtn);
        adicionarHeaderPanel.add(adicionarAutorBtn);
        adicionarHeaderPanel.add(adicionarEditoraBtn);  
        adicionarLivroBtn.setEnabled(false);
        
        adicionarLivroPanel = new JPanel();
        adicionarLivroPanel.setLayout(new GridLayout(7,1));
        livroTituloLabel = new JLabel("Titulo: ");
        livroIsbnLabel = new JLabel("ISBN: ");
        livroAutorLabel = new JLabel("Autores: ");
        livroPrecoLabel = new JLabel("Preco: ");
        livroEditoraLabel = new JLabel("Editora: ");
        livroTituloField = new JTextField(20);
        livroIsbnField = new JTextField(20);
        /////////////// PLACEHOLDER
        livroIsbnField.setForeground(Color.GRAY);
    	livroIsbnField.setText("ISBN com 13 caracteres");
        livroIsbnField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (livroIsbnField.getText().equals("ISBN com 13 caracteres")) {
                	livroIsbnField.setText("");
                	livroIsbnField.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (livroIsbnField.getText().isEmpty()) {
                	livroIsbnField.setForeground(Color.GRAY);
                	livroIsbnField.setText("ISBN com 13 caracteres");
                }
            }
            });
        
        livroIsbnField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) { 
                if (livroIsbnField.getText().length() > 13 )
                    e.consume(); 
            }  
        });
        //////////////
        livroAutorCombo = new JComboBox();
        
       
        livroPrecoField = new JTextField(20);
        livroEditoraCombo = new JComboBox();
        
        adicionarLivroSalvarBtn = new JButton("Salvar");
        
        addLivroTituloPanel = new JPanel();
        addLivroTituloPanel.add(livroTituloLabel);
        addLivroTituloPanel.add(livroTituloField);
        adicionarLivroPanel.add(addLivroTituloPanel);
        
        addLivroIsbnPanel = new JPanel();
        addLivroIsbnPanel.add(livroIsbnLabel);
        addLivroIsbnPanel.add(livroIsbnField);
        adicionarLivroPanel.add(addLivroIsbnPanel);
        
        maisAddBtn = new JButton("+");
        menosAddBtn = new JButton("-");
        addLivroAutorPanel = new JPanel();
        addLivroAutorPanel.add(livroAutorLabel);
        addLivroAutorPanel.add(livroAutorCombo);
        addLivroAutorPanel.add(maisAddBtn);
        addLivroAutorPanel.add(menosAddBtn);
        adicionarLivroPanel.add(addLivroAutorPanel);
        
        addLivroAutoresPanel = new JPanel();
        addLivroAutoresLabel = new JLabel("Autores adicionados: ");
        addLivroAutoresField = new JLabel("");
        addLivroAutoresPanel.add(addLivroAutoresLabel);
        addLivroAutoresPanel.add(addLivroAutoresField);
        adicionarLivroPanel.add(addLivroAutoresPanel);
        
        addLivroPrecoPanel = new JPanel();
        addLivroPrecoPanel.add(livroPrecoLabel);
        addLivroPrecoPanel.add(livroPrecoField);
        adicionarLivroPanel.add(addLivroPrecoPanel);
        
        addLivroEditoraPanel = new JPanel();
        addLivroEditoraPanel.add(livroEditoraLabel);
        addLivroEditoraPanel.add(livroEditoraCombo);
        adicionarLivroPanel.add(addLivroEditoraPanel);
        
        addLivroBtnPanel = new JPanel();
        addLivroBtnPanel.add(adicionarLivroSalvarBtn);
        adicionarLivroPanel.add(addLivroBtnPanel);
        
        adicionarAutorPanel = new JPanel();
        adicionarAutorPanel.setLayout(new GridLayout(3,1));
        autorNomeLabel = new JLabel("Nome: ");
        autorSobrenomeLabel = new JLabel("Sobrenome: ");
        
        autorNomeField = new JTextField(20);
        autorSobrenomeField = new JTextField(20);
        
        adicionarAutorSalvarBtn = new JButton("Salvar");
        
        
        addAutorNomePanel = new JPanel();
        addAutorNomePanel.add(autorNomeLabel);
        addAutorNomePanel.add(autorNomeField);
        adicionarAutorPanel.add(addAutorNomePanel);
        
        addAutorSobrenomePanel = new JPanel();
        addAutorSobrenomePanel.add(autorSobrenomeLabel);
        addAutorSobrenomePanel.add(autorSobrenomeField);
        adicionarAutorPanel.add(addAutorSobrenomePanel);
        
        addAutorBtnPanel = new JPanel();
        addAutorBtnPanel.add(adicionarAutorSalvarBtn); 
        adicionarAutorPanel.add(addAutorBtnPanel);
        
        adicionarEditoraPanel = new JPanel();
        adicionarEditoraPanel.setLayout(new GridLayout(3,1));
        editoraNomeLabel = new JLabel("Nome: ");
        editoraUrlLabel = new JLabel("Url: ");
        
        editoraNomeField = new JTextField(20);
        editoraUrlField = new JTextField(20);
        
        adicionarEditoraSalvarBtn = new JButton("Salvar");
        
        
        addEditoraNomePanel = new JPanel();
        addEditoraNomePanel.add(editoraNomeLabel);
        addEditoraNomePanel.add(editoraNomeField);
        adicionarEditoraPanel.add(addEditoraNomePanel);
        
        addEditoraUrlPanel = new JPanel();
        addEditoraUrlPanel.add(editoraUrlLabel);
        addEditoraUrlPanel.add(editoraUrlField);
        adicionarEditoraPanel.add(addEditoraUrlPanel);
        
        addEditoraBtnPanel = new JPanel();
        addEditoraBtnPanel.add(adicionarEditoraSalvarBtn);
        adicionarEditoraPanel.add(addEditoraBtnPanel);
        
        adicionarCardPanel = new JPanel();
        adicionarCardLayout = new CardLayout();
        adicionarCardPanel.setLayout(adicionarCardLayout);
        adicionarCardPanel.add("adicionarLivroPanel", adicionarLivroPanel);
        adicionarCardPanel.add("adicionarAutorPanel", adicionarAutorPanel);
        adicionarCardPanel.add("adicionarEditoraPanel", adicionarEditoraPanel);
        
        //EDITAR
        editarHeaderPanel = new JPanel();
        editarLivroBtn = new JButton("Livros");
        editarAutorBtn = new JButton("Autores");
        editarEditoraBtn = new JButton("Editora");
        editarHeaderPanel.add(editarLivroBtn);
        editarHeaderPanel.add(editarAutorBtn);
        editarHeaderPanel.add(editarEditoraBtn);  
        editarLivroBtn.setEnabled(false);
        
        editarLivroPanel = new JPanel();
        editarLivroPanel.setLayout(new BorderLayout());
        editarLivroPanel = new JPanel();
        editarLivroPanel.setLayout(new GridLayout(8,1));
        editarLivroTituloLabel = new JLabel("Titulo: ");
        editarLivroIsbnLabel = new JLabel("ISBN: ");
        editarLivroAutorLabel = new JLabel("Autores: ");
        editarLivroPrecoLabel = new JLabel("Preco: ");
        editarLivroEditoraLabel = new JLabel("Editora atual: ");
        editarLivroTituloField = new JTextField(35);
        
        
        editarLivroPrecoField = new JTextField(20);
        editarLivroEditoraField = new JLabel();
        editarLivroBuscarBtn = new JButton("Buscar pelo ISBN");
        editarLivroSalvarBtn = new JButton("Salvar");
        
        editarLivroEditoraCombo = new JComboBox();
        

        edtLivroIsbnPanel = new JPanel();
        edtLivroIsbnPanel.add(editarLivroIsbnLabel);
        edtLivroIsbnCombo = new JComboBox();
        
        edtLivroIsbnPanel.add(edtLivroIsbnCombo);
        editarLivroPanel.add(edtLivroIsbnPanel);
        
        edtLivroTituloPanel = new JPanel();
        edtLivroTituloPanel.add(editarLivroTituloLabel);
        edtLivroTituloPanel.add(editarLivroTituloField);
        editarLivroPanel.add(edtLivroTituloPanel);
                      
        edtLivroAutorPanel = new JPanel();
        edtLivroAutorPanel.add(editarLivroAutorLabel);
        
        edtLivroAutorLabel = new JLabel("");
        menosEdtBtn = new JButton("-");
        
        edtLivroAutorPanel.add(edtLivroAutorLabel);
        edtLivroAutorPanel.add(menosEdtBtn);
        editarLivroPanel.add(edtLivroAutorPanel);
        
        edtLivroNAutorPanel = new JPanel();
        edtLivroNAutorLabel = new JLabel("Adicionar autor: ");
        edtLivroNAutorCombo = new JComboBox();
        maisEdtBtn = new JButton("+");
        edtLivroNAutorPanel.add(edtLivroNAutorLabel);
        edtLivroNAutorPanel.add(edtLivroNAutorCombo);
        edtLivroNAutorPanel.add(maisEdtBtn);       
        editarLivroPanel.add(edtLivroNAutorPanel);
        
        edtLivroPrecoPanel = new JPanel();
        edtLivroPrecoPanel.add(editarLivroPrecoLabel);
        edtLivroPrecoPanel.add(editarLivroPrecoField);
        editarLivroPanel.add(edtLivroPrecoPanel);
        
        edtLivroEditoraPanel = new JPanel();
        edtLivroEditoraPanel.add(editarLivroEditoraLabel);
        edtLivroEditoraPanel.add(editarLivroEditoraField);
        editarLivroPanel.add(edtLivroEditoraPanel);
        
        edtLivroEditoraComboPanel = new JPanel();
        edtLivroEditoraComboLabel = new JLabel("Nova editora: ");
        edtLivroEditoraComboPanel.add(edtLivroEditoraComboLabel);
        edtLivroEditoraComboPanel.add(editarLivroEditoraCombo);
        
        editarLivroPanel.add(edtLivroEditoraComboPanel);
        
        edtLivroBtnPanel = new JPanel();
        edtLivroBtnPanel.add(editarLivroSalvarBtn);
        edtLivroBtnPanel.add(editarLivroBuscarBtn);
        editarLivroPanel.add(edtLivroBtnPanel);
        
        
        editarAutorPanel = new JPanel();
        editarAutorPanel.setLayout(new GridLayout(4,1));
        editarAutorNomeLabel = new JLabel("Nome: ");
        editarAutorSobrenomeLabel = new JLabel("Sobrenome: ");
        editarAutorIdLabel = new JLabel("ID: ");
        editarAutorNomeField = new JTextField(20);
        editarAutorSobrenomeField = new JTextField(20);
        
        editarAutorSalvarBtn = new JButton("Salvar");
        editarAutorBuscarBtn = new JButton("Buscar pelo ID");

        edtAutorIdPanel = new JPanel();
        edtAutorIdPanel.add(editarAutorIdLabel);
        edtAutorIdCombo = new JComboBox();
        
        edtAutorIdPanel.add(edtAutorIdCombo);
        editarAutorPanel.add(edtAutorIdPanel);
        
        edtAutorNomePanel = new JPanel();
        edtAutorNomePanel.add(editarAutorNomeLabel);
        edtAutorNomePanel.add(editarAutorNomeField);
        editarAutorPanel.add(edtAutorNomePanel);
        
        edtAutorSobrenomePanel = new JPanel();
        edtAutorSobrenomePanel.add(editarAutorSobrenomeLabel);
        edtAutorSobrenomePanel.add(editarAutorSobrenomeField);
        editarAutorPanel.add(edtAutorSobrenomePanel);
        
        edtAutorBtnPanel = new JPanel();  
        edtAutorBtnPanel.add(editarAutorSalvarBtn);
        edtAutorBtnPanel.add(editarAutorBuscarBtn);  
        editarAutorPanel.add(edtAutorBtnPanel);
        
        editarEditoraPanel = new JPanel();
        editarEditoraPanel.setLayout(new GridLayout(4,1));
        editarEditoraNomeLabel = new JLabel("Nome: ");
        editarEditoraUrlLabel = new JLabel("URL: ");
        editarEditoraIdLabel = new JLabel("ID: ");
        editarEditoraNomeField = new JTextField(20);
        editarEditoraUrlField = new JTextField(20);
        
        editarEditoraSalvarBtn = new JButton("Salvar");
        editarEditoraBuscarBtn = new JButton("Buscar pelo ID");

        edtEditoraIdPanel = new JPanel();
        edtEditoraIdPanel.add(editarEditoraIdLabel);
        edtEditoraIdCombo = new JComboBox();
        
        edtEditoraIdPanel.add(edtEditoraIdCombo); 
        editarEditoraPanel.add(edtEditoraIdPanel);
        
        edtEditoraNomePanel = new JPanel();
        edtEditoraNomePanel.add(editarEditoraNomeLabel);
        edtEditoraNomePanel.add(editarEditoraNomeField);
        editarEditoraPanel.add(edtEditoraNomePanel);
        
        edtEditoraUrlPanel = new JPanel();
        edtEditoraUrlPanel.add(editarEditoraUrlLabel);
        edtEditoraUrlPanel.add(editarEditoraUrlField);
        editarEditoraPanel.add(edtEditoraUrlPanel);
        
        edtEditoraBtnPanel = new JPanel();
        edtEditoraBtnPanel.add(editarEditoraSalvarBtn);
        edtEditoraBtnPanel.add(editarEditoraBuscarBtn);
        editarEditoraPanel.add(edtEditoraBtnPanel);
              
        editarCardPanel = new JPanel();
        editarCardLayout = new CardLayout();
        editarCardPanel.setLayout(editarCardLayout);
        editarCardPanel.add("editarLivroPanel", editarLivroPanel);
        editarCardPanel.add("editarAutorPanel", editarAutorPanel);
        editarCardPanel.add("editarEditoraPanel", editarEditoraPanel);
        
        //EXCLUIR
        excluirHeaderPanel = new JPanel();
        excluirLivroBtn = new JButton("Livros");
        excluirAutorBtn = new JButton("Autores");
        excluirEditoraBtn = new JButton("Editora");
        excluirHeaderPanel.add(excluirLivroBtn);
        excluirHeaderPanel.add(excluirAutorBtn);
        excluirHeaderPanel.add(excluirEditoraBtn);  
        excluirLivroBtn.setEnabled(false);
        
        excluirLivroPanel = new JPanel();
        excluirLivroPanel.setLayout(new BorderLayout());
        excluirLivroPanel = new JPanel();
        excluirLivroPanel.setLayout(new GridLayout(6,1));
        excluirLivroTituloLabel = new JLabel("Titulo: ");
        excluirLivroIsbnLabel = new JLabel("ISBN: ");
        excluirLivroAutorLabel = new JLabel("Autor: ");
        excluirLivroPrecoLabel = new JLabel("Preco: ");
        excluirLivroEditoraLabel = new JLabel("Editora: ");
        excluirLivroTituloField = new JLabel();
        
        excluirLivroAutorField = new JLabel();
        excluirLivroPrecoField = new JLabel();
        excluirLivroEditoraField = new JLabel();        
        excluirLivroExcluirBtn = new JButton("Excluir");
        excluirLivroBuscarBtn = new JButton("Buscar pelo ISBN");
        
        excLivroIsbnPanel = new JPanel();
        excLivroIsbnPanel.add(excluirLivroIsbnLabel);
        excLivroIsbnCombo = new JComboBox();
        
        excLivroIsbnPanel.add(excLivroIsbnCombo);
        excluirLivroPanel.add(excLivroIsbnPanel);
        
        excLivroTituloPanel = new JPanel();
        excLivroTituloPanel.add(excluirLivroTituloLabel);
        excLivroTituloPanel.add(excluirLivroTituloField);
        excluirLivroPanel.add(excLivroTituloPanel);
                      
        excLivroAutorPanel = new JPanel();
        excLivroAutorPanel.add(excluirLivroAutorLabel);
        excLivroAutorPanel.add(excluirLivroAutorField);
        excluirLivroPanel.add(excLivroAutorPanel);
        
        excLivroPrecoPanel = new JPanel();
        excLivroPrecoPanel.add(excluirLivroPrecoLabel);
        excLivroPrecoPanel.add(excluirLivroPrecoField);
        excluirLivroPanel.add(excLivroPrecoPanel);
        
        excLivroEditoraPanel = new JPanel();
        excLivroEditoraPanel.add(excluirLivroEditoraLabel);
        excLivroEditoraPanel.add(excluirLivroEditoraField);
        excluirLivroPanel.add(excLivroEditoraPanel);
        
        excLivroBtnPanel = new JPanel();
        excLivroBtnPanel.add(excluirLivroExcluirBtn);
        excLivroBtnPanel.add(excluirLivroBuscarBtn);
        excluirLivroPanel.add(excLivroBtnPanel);
        
        excluirAutorPanel = new JPanel();
        excluirAutorPanel.setLayout(new GridLayout(4,1));
        excluirAutorNomeLabel = new JLabel("Nome: ");
        excluirAutorSobrenomeLabel = new JLabel("Sobrenome: ");
        excluirAutorIdLabel = new JLabel("ID: ");
        excluirAutorNomeField = new JLabel();
        excluirAutorSobrenomeField = new JLabel();
        
        excluirAutorExcluirBtn = new JButton("Excluir");
        excluirAutorBuscarBtn = new JButton("Buscar pelo ID");
        
        excAutorIdPanel = new JPanel();
        excAutorIdPanel.add(excluirAutorIdLabel);
        excAutorIdCombo = new JComboBox();
        
        excAutorIdPanel.add(excAutorIdCombo);
        excluirAutorPanel.add(excAutorIdPanel);
        
        excAutorNomePanel = new JPanel();
        excAutorNomePanel.add(excluirAutorNomeLabel);
        excAutorNomePanel.add(excluirAutorNomeField);
        excluirAutorPanel.add(excAutorNomePanel);
        
        excAutorSobrenomePanel = new JPanel();
        excAutorSobrenomePanel.add(excluirAutorSobrenomeLabel);
        excAutorSobrenomePanel.add(excluirAutorSobrenomeField);
        excluirAutorPanel.add(excAutorSobrenomePanel);
        
        excAutorBtnPanel = new JPanel();  
        excAutorBtnPanel.add(excluirAutorExcluirBtn);
        excAutorBtnPanel.add(excluirAutorBuscarBtn);  
        excluirAutorPanel.add(excAutorBtnPanel);
        
        excluirEditoraPanel = new JPanel();
        excluirEditoraPanel.setLayout(new GridLayout(4,1));
        excluirEditoraNomeLabel = new JLabel("Nome: ");
        excluirEditoraUrlLabel = new JLabel("URL: ");
        excluirEditoraIdLabel = new JLabel("ID: ");
        excluirEditoraNomeField = new JLabel();
        excluirEditoraUrlField = new JLabel();
        
        excluirEditoraExcluirBtn = new JButton("Excluir");
        excluirEditoraBuscarBtn = new JButton("Buscar pelo ID");

        excEditoraIdPanel = new JPanel();
        excEditoraIdPanel.add(excluirEditoraIdLabel); 
        excEditoraIdCombo = new JComboBox();
        
        excEditoraIdPanel.add(excEditoraIdCombo); 
        excluirEditoraPanel.add(excEditoraIdPanel);
        
        excEditoraNomePanel = new JPanel();
        excEditoraNomePanel.add(excluirEditoraNomeLabel);
        excEditoraNomePanel.add(excluirEditoraNomeField);
        excluirEditoraPanel.add(excEditoraNomePanel);
        
        excEditoraUrlPanel = new JPanel();
        excEditoraUrlPanel.add(excluirEditoraUrlLabel);
        excEditoraUrlPanel.add(excluirEditoraUrlField);
        excluirEditoraPanel.add(excEditoraUrlPanel);
        
        excEditoraBtnPanel = new JPanel();
        excEditoraBtnPanel.add(excluirEditoraExcluirBtn);
        excEditoraBtnPanel.add(excluirEditoraBuscarBtn);
        excluirEditoraPanel.add(excEditoraBtnPanel);
        
        excluirCardPanel = new JPanel();
        excluirCardLayout = new CardLayout();
        excluirCardPanel.setLayout(excluirCardLayout);
        excluirCardPanel.add("excluirLivroPanel", excluirLivroPanel);
        excluirCardPanel.add("excluirAutorPanel", excluirAutorPanel);
        excluirCardPanel.add("excluirEditoraPanel", excluirEditoraPanel);
        
        //JANELA CONTENT               
        listarContent = new JPanel(new BorderLayout());
        listarContent.add(listarHeaderPanel, BorderLayout.NORTH);
        listarContent.add(listarCardPanel, BorderLayout.CENTER);
        
        adicionarContent = new JPanel(new BorderLayout());
        adicionarContent.add(adicionarHeaderPanel, BorderLayout.NORTH);
        adicionarContent.add(adicionarCardPanel, BorderLayout.CENTER);
               
        editarContent = new JPanel(new BorderLayout());
        editarContent.add(editarHeaderPanel, BorderLayout.NORTH);
        editarContent.add(editarCardPanel, BorderLayout.CENTER);
        
        excluirContent = new JPanel(new BorderLayout());
        excluirContent.add(excluirHeaderPanel, BorderLayout.NORTH);
        excluirContent.add(excluirCardPanel, BorderLayout.CENTER);
        
        //FOOTER
        acoesFooterPanel = new JPanel();
        adicionarBtn = new JButton("Adicionar");
        editarBtn = new JButton("Editar");
        excluirBtn = new JButton("Excluir");
        listarBtn = new JButton("Listar");
        listarBtn.setEnabled(false);

        acoesFooterPanel.setLayout(new GridLayout(4,1));
        acoesFooterPanel.add(listarBtn);
        acoesFooterPanel.add(adicionarBtn);
        acoesFooterPanel.add(editarBtn);
        acoesFooterPanel.add(excluirBtn);
        
        
        //CONTENT CARD
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.add("Listar", listarContent);
        contentPanel.add("Adicionar", adicionarContent);
        contentPanel.add("Editar", editarContent);
        contentPanel.add("Excluir", excluirContent);
        
        Container janela = getContentPane();
        janela.setLayout(new BorderLayout());
        
        janela.add(contentPanel, BorderLayout.CENTER);
        janela.add(acoesFooterPanel, BorderLayout.WEST);
                             
        
        
        //DEFAULT CONFIG
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(850, 500);
        setVisible(true);
        //FIM DO CODIGO
    }
    
    //MeTODOS PARA SETAR AcoES EM BOToES
    //MeTODOS PARA SETAR A AcaO DE BUSCA EM SEUS RESPECTIVOS BOToES
    public void setBuscaLivroBtnAl(ActionListener al){
        //botao.addActionListener(al);
        buscaLivroBtn.addActionListener(al);
    }
    public void setBuscaAutorBtnAl(ActionListener al){
        //botao.addActionListener(al);
        buscaAutorBtn.addActionListener(al);
    }
    public void setBuscaEditoraBtnAl(ActionListener al){
        //botao.addActionListener(al);
        buscaEditoraBtn.addActionListener(al);
    }
    
    //SETAR ACaO AOS BOToES DE BUSCA DE EDITAR/EXCLUIR
    public void setEdtBuscaLivroAl(ActionListener al){
        editarLivroBuscarBtn.addActionListener(al);
    }
    
    public void setEdtBuscaAutorAl(ActionListener al){
        editarAutorBuscarBtn.addActionListener(al);
    }
    
    public void setEdtBuscaEditoraAl(ActionListener al){
        editarEditoraBuscarBtn.addActionListener(al);
    }
    
    public void setExcBuscaLivroAl(ActionListener al){
        excluirLivroBuscarBtn.addActionListener(al);
    }
    
    public void setExcBuscaAutorAl(ActionListener al){
        excluirAutorBuscarBtn.addActionListener(al);
    }
    
    public void setExcBuscaEditoraAl(ActionListener al){
        excluirEditoraBuscarBtn.addActionListener(al);
    }
    
    //SETAR AcaO DE ADICIONAR/EDITAR/EXCLUIR AOS BOToES
    public void setAddLivroAl(ActionListener al){
        adicionarLivroSalvarBtn.addActionListener(al);
    }
    public void setAddAutorAl(ActionListener al){
        adicionarAutorSalvarBtn.addActionListener(al);
    }
    public void setAddEditoraAl(ActionListener al){
        adicionarEditoraSalvarBtn.addActionListener(al);
    }
    public void setEdtLivroAl(ActionListener al){
        editarLivroSalvarBtn.addActionListener(al);
    }
    public void setEdtAutorAl(ActionListener al){
        editarAutorSalvarBtn.addActionListener(al);
    }
    public void setEdtEditoraAl(ActionListener al){
        editarEditoraSalvarBtn.addActionListener(al);
    }
    public void setExcLivroAl(ActionListener al){
        excluirLivroExcluirBtn.addActionListener(al);
    }
    public void setExcAutorAl(ActionListener al){
        excluirAutorExcluirBtn.addActionListener(al);
    }
    public void setExcEditoraAl(ActionListener al){
        excluirEditoraExcluirBtn.addActionListener(al);
    }
    //BOTOES DE ADICIONAR/REMOVER AUTOR DO LIVRO EM ADICIONAR
    public void setAddMaisAl(ActionListener al){
        maisAddBtn.addActionListener(al);
    }
    public void setAddMenosAl(ActionListener al){
        menosAddBtn.addActionListener(al);
    }
    public void setEdtMaisAl(ActionListener al){
        maisEdtBtn.addActionListener(al);
    }
    public void setEdtMenosAl(ActionListener al){
        menosEdtBtn.addActionListener(al);
    }
    
    //ADICIONAR AcaO AOS BOToES DE SALVAR ALTERAcoES E CONFIRMAR EXCLUSaO
    
    //MeTODOS PARA REDIRECIONAR DADOS
    //MeTODOS PARA PALAVRA-CHAVE DA BUSCA
    public String getLivroBusca(){
        return this.buscaLivroField.getText()+" | "+String.valueOf(buscaLivroCombo.getSelectedItem());
    }
    public String getAutorBusca(){
        return this.buscaAutorField.getText();
    }
    public String getEditoraBusca(){
        return this.buscaEditoraField.getText();
    }
    
    //MeTODOS PARA ISBN DE EDITAR LIVRO 
    public String getEdtLivroIsbn(){
        int index = String.valueOf(edtLivroIsbnCombo.getSelectedItem()).indexOf(" ");
        return String.valueOf(edtLivroIsbnCombo.getSelectedItem()).substring(0, index);
    }
    
    public Livro getEdtLivro(){
        Livro livro = null;
        String titulo, isbn, publisher, pid, pname, string_preco;
        double preco=-1;
        isbn = String.valueOf(edtLivroIsbnCombo.getSelectedItem());
        isbn = isbn.substring(0, isbn.indexOf(" "));
        titulo = editarLivroTituloField.getText().trim();
        string_preco = editarLivroPrecoField.getText().trim();
        string_preco = string_preco.replace(",", ".");
        if(!(string_preco.isEmpty()) && (string_preco.matches("[0-9]+.[0-9]+$"))){
            //matches(regex=regular expression) verifica a ocorrencia dos algarismos 0 ao 9 [0-9] uma ou mais vezes(+),
            //seguido de um ponto (.), seguido da ocorrencia dos algarismos 0 ao 9 [0-9] uma ou mais vezes(+) 
            //evitando a validacao parcial da string ($)
            preco = Double.parseDouble(string_preco);
        } 
        livro = new Livro(isbn, titulo, preco);
        
        publisher = String.valueOf(editarLivroEditoraCombo.getSelectedItem());
        pid = publisher.substring(0, publisher.indexOf(" "));
        pname = publisher.substring(publisher.indexOf(" ")+2);
        livro.setEditora(new Editora(pname, "", Integer.parseInt(pid)));
        
        return livro;
    }
    //MeTODOS PARA ID DE EDITAR AUTOR
    public String getEdtAutorId(){
        int index = String.valueOf(edtAutorIdCombo.getSelectedItem()).indexOf(" ");
        return String.valueOf(edtAutorIdCombo.getSelectedItem()).substring(0, index);
    }
    public Autor getEdtAutor(){
        Autor autor = null;
        String nome, snome, sid; int id;
        sid = String.valueOf(edtAutorIdCombo.getSelectedItem());
        sid = sid.substring(0, sid.indexOf(" "));
        id = Integer.parseInt(sid);
        nome = editarAutorNomeField.getText().trim();
        nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
        snome = editarAutorSobrenomeField.getText().trim();
        snome = snome.substring(0,1).toUpperCase() + snome.substring(1).toLowerCase();
        autor = new Autor(nome, snome, id);
        return autor;
    }
    //MeTODOS PARA ID DE EDITAR EDITORA
    public String getEdtEditoraId(){
        int index = String.valueOf(edtEditoraIdCombo.getSelectedItem()).indexOf(" ");
        return String.valueOf(edtEditoraIdCombo.getSelectedItem()).substring(0, index);
    }
    public Editora getEdtEditora(){
        Editora editora = null;
        String nome, url, sid; int id;
        sid = String.valueOf(edtEditoraIdCombo.getSelectedItem());
        sid = sid.substring(0, sid.indexOf(" "));
        id = Integer.parseInt(sid);
        nome = editarEditoraNomeField.getText().trim();

        nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
        url = editarEditoraUrlField.getText().trim();
        editora = new Editora(nome, url, id);
        return editora;
    }
    //MeTODOS PARA REDIRECIONAR CAMPOS DE ADICIONAR
    public Livro getAddLivro(){
        Livro livro = null;
        String titulo, isbn, string_preco, publisher, pid, pname;
        double preco=-1;
        titulo = livroTituloField.getText().trim();
        isbn = livroIsbnField.getText().trim();
        string_preco = livroPrecoField.getText().trim();
        string_preco = string_preco.replace(",", ".");
        if(!(string_preco.isEmpty()) || (string_preco.matches("[0-9]+.[0-9]+$"))){
            //matches(regex=regular expression) verifica a ocorrencia dos algarismos 0 ao 9 [0-9] uma ou mais vezes(+),
            //seguido de um ponto (.), seguido da ocorrencia dos algarismos 0 ao 9 [0-9] uma ou mais vezes(+) 
            //evitando a validacao parcial da string ($)
            preco = Double.parseDouble(string_preco);
        }               
        
        livro = new Livro(isbn, titulo, preco);
        
        publisher = String.valueOf(livroEditoraCombo.getSelectedItem());
        pid = publisher.substring(0, publisher.indexOf(" "));
        pname = publisher.substring(publisher.indexOf(" ")+2);
        livro.setEditora(new Editora(pname, "", Integer.parseInt(pid)));
        
        return livro;
    }
    public Autor getAddAutor(){
        Autor autor = null;
        String nome, snome; int id;
        id = 0;
        nome = autorNomeField.getText().trim();
        nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
        snome = autorSobrenomeField.getText().trim();
        snome = snome.substring(0,1).toUpperCase() + snome.substring(1).toLowerCase();
        autor = new Autor(nome, snome, id);
        return autor;
    }
    public Editora getAddEditora(){
        Editora editora = null;
        String nome, url; int id;
        id = 0;
        nome = editoraNomeField.getText().trim();
        nome = nome.substring(0,1).toUpperCase() + nome.substring(1).toLowerCase();
        url = editoraUrlField.getText().trim();
        editora = new Editora(nome, url, id);
        return editora;
    }
    
    //Me‰TODO PARA ISBN DE EXCLUIR AUTOR
    public String getExcLivroIsbn(){
        int index = String.valueOf(excLivroIsbnCombo.getSelectedItem()).indexOf(" ");
        return String.valueOf(excLivroIsbnCombo.getSelectedItem()).substring(0, index);
    }
    //MeTODOS PARA ID DE EXCLUIR AUTOR
    public String getExcAutorId(){
        int index = String.valueOf(excAutorIdCombo.getSelectedItem()).indexOf(" ");
        return String.valueOf(excAutorIdCombo.getSelectedItem()).substring(0, index);
    }
    //MeTODOS PARA ID DE EXCLUIR EDITORA
    public String getExcEditoraId(){
        int index = String.valueOf(excEditoraIdCombo.getSelectedItem()).indexOf(" ");
        return String.valueOf(excEditoraIdCombo.getSelectedItem()).substring(0, index);
    }
    //ADICIONAR/REMOVER AUTOR DE ADD/EDT
    public String getEdtLivroMaisAutor(){
        String autor = String.valueOf(edtLivroNAutorCombo.getSelectedItem()).trim();
        return autor;
    }
    public void livroAutoresEdtField(ArrayList<String> aAutores){
        edtLivroAutorLabel.setText("");
        for(String autor : aAutores){
            edtLivroAutorLabel.setText(edtLivroAutorLabel.getText()+autor.substring(autor.indexOf(" ")+2)+"/");
        }
    }
    
    public String getAddLivroMaisAutor(){
        String autor = String.valueOf(livroAutorCombo.getSelectedItem()).trim();
        return autor;
    }

    public void livroAutoresAddField(ArrayList<String> aAutores){
        addLivroAutoresField.setText("");
        for(String autor : aAutores){
            addLivroAutoresField.setText(addLivroAutoresField.getText()+autor.substring(autor.indexOf(" ")+2)+"/");
        }
    }
    
    //MeTODOS PARA MODIFICAR COMPONENTES
    //MeTODOS PARA ADICIONAR REGISTROS NA TABELA
    public void mostraTabelaLivro(ArrayList<Livro> livros){
    livroModel.setRowCount(0);
    for(Livro livro : livros)
      livroModel.addRow(new Object[]{
        livro.getIsbn(), 
        livro.getTitulo(), 
        livro.getAutores().get(0).getNome(), 
        livro.getEditora().getNome(), 
        livro.getPreco()
      });   
  }
    
    public void mostraTabelaAutor(ArrayList<Autor> autores){
    autorModel.setRowCount(0);
    for(Autor autor : autores)
      autorModel.addRow(new Object[]{
        autor.getIdAutor(), 
        autor.getNome(), 
        autor.getSobrenome()
      });   
  }
    
    public void mostraTabelaEditora(ArrayList<Editora> editoras){
    editoraModel.setRowCount(0);
    for(Editora editora : editoras)
      editoraModel.addRow(new Object[]{
        editora.getIdEditora(), 
        editora.getNome(), 
        editora.getUrl()
      });   
  }
    
    //MeTODOS PARA POPULAR JCOMBOBOXES
    public void autorIdCombo(ArrayList<Autor> autores){
        livroAutorCombo.removeAllItems();
        edtAutorIdCombo.removeAllItems();
        excAutorIdCombo.removeAllItems();
        edtLivroNAutorCombo.removeAllItems();
        for(Autor autor : autores){
            livroAutorCombo.addItem(autor.getIdAutor()+" | "+autor.getNome());
            edtAutorIdCombo.addItem(autor.getIdAutor()+" | "+autor.getNome());
            excAutorIdCombo.addItem(autor.getIdAutor()+" | "+autor.getNome());
            edtLivroNAutorCombo.addItem(autor.getIdAutor()+" | "+autor.getNome());
        }
    }
    
    public void editoraIdCombo(ArrayList<Editora> editoras){
        livroEditoraCombo.removeAllItems();
        edtEditoraIdCombo.removeAllItems();
        excEditoraIdCombo.removeAllItems();
        editarLivroEditoraCombo.removeAllItems();
        for(Editora editora : editoras){
            livroEditoraCombo.addItem(editora.getIdEditora()+" | "+editora.getNome());
            edtEditoraIdCombo.addItem(editora.getIdEditora()+" | "+editora.getNome());
            excEditoraIdCombo.addItem(editora.getIdEditora()+" | "+editora.getNome());
            editarLivroEditoraCombo.addItem(editora.getIdEditora()+" | "+editora.getNome());
        }
    }
    
    public void livroIsbnCombo(ArrayList<Livro> livros){
            edtLivroIsbnCombo.removeAllItems();
            excLivroIsbnCombo.removeAllItems();
        for(Livro livro : livros){
            edtLivroIsbnCombo.addItem(livro.getIsbn()+" | "+livro.getTitulo());
            excLivroIsbnCombo.addItem(livro.getIsbn()+" | "+livro.getTitulo());
        }
    }    
    
    //COMPLETA CAMPOS ATRAVeS DO COMBOBOX
    public void fillExcLivro(Livro livro){
        excluirLivroTituloField.setText(livro.getTitulo().trim());
        excluirLivroAutorField.setText("");
        for(int i=0 ; i < livro.getAutores().size() ; i++){
            String author_name = livro.getAutores().get(i).getNome().trim()+" "
                                        +livro.getAutores().get(i).getSobrenome().trim();
            excluirLivroAutorField.setText(excluirLivroAutorField.getText()+author_name+ " / ");
        }
        excluirLivroAutorField.setText(excluirLivroAutorField.getText().substring(0, excluirLivroAutorField.getText().length()-2));
        excluirLivroPrecoField.setText(String.valueOf(livro.getPreco()).trim());
        excluirLivroEditoraField.setText(livro.getEditora().getNome().trim());
    }
    
    public void fillExcAutor(Autor autor){
        excluirAutorNomeField.setText(autor.getNome().trim());
        excluirAutorSobrenomeField.setText(autor.getSobrenome().trim());
    }
    
    public void fillExcEditora(Editora editora){
        excluirEditoraNomeField.setText(editora.getNome().trim());
        excluirEditoraUrlField.setText(editora.getUrl().trim());
    }    
    //
    public void fillEdtLivro(Livro livro){
        editarLivroTituloField.setText(livro.getTitulo().trim());
        edtLivroAutorLabel.setText("");
        for(int i=0 ; i < livro.getAutores().size() ; i++){
            String author_name = livro.getAutores().get(i).getNome().trim();
            edtLivroAutorLabel.setText(edtLivroAutorLabel.getText()+author_name+ " / ");
        }
        edtLivroAutorLabel.setText(edtLivroAutorLabel.getText().substring(0, edtLivroAutorLabel.getText().length()-2));
        editarLivroPrecoField.setText(String.valueOf(livro.getPreco()).trim());
        editarLivroEditoraField.setText(livro.getEditora().getNome().trim());
        editarLivroEditoraCombo.setSelectedItem(livro.getEditora().getIdEditora()+" | "+livro.getEditora().getNome());
    }
    
    public void fillEdtAutor(Autor autor){
        editarAutorNomeField.setText(autor.getNome().trim());
        editarAutorSobrenomeField.setText(autor.getSobrenome().trim());
    }
    
    public void fillEdtEditora(Editora editora){
        editarEditoraNomeField.setText(editora.getNome().trim());
        editarEditoraUrlField.setText(editora.getUrl().trim());
    }
    
    //LIMPAR CAMPOS
    public void limpaCampos(){
        excluirLivroTituloField.setText("");            
        excluirLivroAutorField.setText("");
        excluirLivroPrecoField.setText("");
        excluirLivroEditoraField.setText("");
        excluirAutorNomeField.setText("");
        excluirAutorSobrenomeField.setText("");           
        excluirEditoraNomeField.setText("");
        excluirEditoraUrlField.setText("");            
        editarLivroTituloField.setText("");
        editarLivroPrecoField.setText("");
        editarLivroEditoraField.setText("");
        editarAutorNomeField.setText("");
        editarAutorSobrenomeField.setText("");
        editarEditoraNomeField.setText("");
        editarEditoraUrlField.setText("");
        livroTituloField.setText("");
        livroIsbnField.setText("");
        livroPrecoField.setText("");
        autorNomeField.setText("");
        autorSobrenomeField.setText("");
        editoraNomeField.setText("");
        editoraUrlField.setText("");  
        addLivroAutoresField.setText("");
    }
    
    //SETA AcoES PARA TROCA DE CARDS NO CARDLAYOUT / TROCA CARDS NO CARDLAYOUT E BLOQUEIA BOTaO DO CARD ATUAL
    public void setTrocaAbaListar(ActionListener al, int op){
        if(op==1){
            listarLivroBtn.addActionListener(al);
        }
        if(op==2){
            listarAutorBtn.addActionListener(al);
        }
        if(op==3){
            listarEditoraBtn.addActionListener(al);
        }
    }
    
    public void trocaAbaListar(String nomePanel){
        listarCardLayout.show(listarCardPanel, nomePanel);
        if(nomePanel.equals("listarLivroPanel")){
            listarLivroBtn.setEnabled(false);
            listarAutorBtn.setEnabled(true);
            listarEditoraBtn.setEnabled(true);
        }
        if(nomePanel.equals("listarAutorPanel")){
            listarLivroBtn.setEnabled(true);
            listarAutorBtn.setEnabled(false);
            listarEditoraBtn.setEnabled(true);
        }
        if(nomePanel.equals("listarEditoraPanel")){
            listarLivroBtn.setEnabled(true);
            listarAutorBtn.setEnabled(true);
            listarEditoraBtn.setEnabled(false);
        }
    }
    
    public void setTrocaAbaAdicionar(ActionListener al, int op){
        if(op==1){
            adicionarLivroBtn.addActionListener(al);
        }
        if(op==2){
            adicionarAutorBtn.addActionListener(al);
        }
        if(op==3){
            adicionarEditoraBtn.addActionListener(al);
        }
    }
    
    public void trocaAbaAdicionar(String nomePanel){
        adicionarCardLayout.show(adicionarCardPanel, nomePanel);
        if(nomePanel.equals("adicionarLivroPanel")){
            adicionarLivroBtn.setEnabled(false);
            adicionarAutorBtn.setEnabled(true);
            adicionarEditoraBtn.setEnabled(true);
        }
        if(nomePanel.equals("adicionarAutorPanel")){
            adicionarLivroBtn.setEnabled(true);
            adicionarAutorBtn.setEnabled(false);
            adicionarEditoraBtn.setEnabled(true);
        }
        if(nomePanel.equals("adicionarEditoraPanel")){
            adicionarLivroBtn.setEnabled(true);
            adicionarAutorBtn.setEnabled(true);
            adicionarEditoraBtn.setEnabled(false);
        }
    }
    
    public void setTrocaAbaEditar(ActionListener al, int op){
        if(op==1){
            editarLivroBtn.addActionListener(al);
        }
        if(op==2){
            editarAutorBtn.addActionListener(al);
        }
        if(op==3){
            editarEditoraBtn.addActionListener(al);
        }
    }
    
    public void trocaAbaEditar(String nomePanel){
        editarCardLayout.show(editarCardPanel, nomePanel);
        if(nomePanel.equals("editarLivroPanel")){
            editarLivroBtn.setEnabled(false);
            editarAutorBtn.setEnabled(true);
            editarEditoraBtn.setEnabled(true);
        }
        if(nomePanel.equals("editarAutorPanel")){
            editarLivroBtn.setEnabled(true);
            editarAutorBtn.setEnabled(false);
            editarEditoraBtn.setEnabled(true);
        }
        if(nomePanel.equals("editarEditoraPanel")){
            editarLivroBtn.setEnabled(true);
            editarAutorBtn.setEnabled(true);
            editarEditoraBtn.setEnabled(false);
        }
    }
    
    public void setTrocaAbaExcluir(ActionListener al, int op){
        if(op==1){
            excluirLivroBtn.addActionListener(al);
        }
        if(op==2){
            excluirAutorBtn.addActionListener(al);
        }
        if(op==3){
            excluirEditoraBtn.addActionListener(al);
        }
    }
    
    public void trocaAbaExcluir(String nomePanel){
        excluirCardLayout.show(excluirCardPanel, nomePanel);
        if(nomePanel.equals("excluirLivroPanel")){
            excluirLivroBtn.setEnabled(false);
            excluirAutorBtn.setEnabled(true);
            excluirEditoraBtn.setEnabled(true);
        }
        if(nomePanel.equals("excluirAutorPanel")){
            excluirLivroBtn.setEnabled(true);
            excluirAutorBtn.setEnabled(false);
            excluirEditoraBtn.setEnabled(true);
        }
        if(nomePanel.equals("excluirEditoraPanel")){
            excluirLivroBtn.setEnabled(true);
            excluirAutorBtn.setEnabled(true);
            excluirEditoraBtn.setEnabled(false);
        }
    }
    
    public void setTrocaAbaAcoes(ActionListener al, int op){
        if(op==1){
            listarBtn.addActionListener(al);
        }
        if(op==2){
            adicionarBtn.addActionListener(al);
        }
        if(op==3){
            editarBtn.addActionListener(al);
        }
        if(op==4){
            excluirBtn.addActionListener(al);
        }
        
    }
    
    public void trocaAbaAcoes(String nomePanel){
        cardLayout.show(contentPanel, nomePanel);
        if(nomePanel.equals("Listar")){
            listarBtn.setEnabled(false);
            adicionarBtn.setEnabled(true);
            editarBtn.setEnabled(true);
            excluirBtn.setEnabled(true);
        }
        if(nomePanel.equals("Adicionar")){
            listarBtn.setEnabled(true);
            adicionarBtn.setEnabled(false);
            editarBtn.setEnabled(true);
            excluirBtn.setEnabled(true);
        }
        if(nomePanel.equals("Editar")){
            listarBtn.setEnabled(true);
            adicionarBtn.setEnabled(true);
            editarBtn.setEnabled(false);
            excluirBtn.setEnabled(true);
        }
        if(nomePanel.equals("Excluir")){
            listarBtn.setEnabled(true);
            adicionarBtn.setEnabled(true);
            editarBtn.setEnabled(true);
            excluirBtn.setEnabled(false);
        }
    }

}


