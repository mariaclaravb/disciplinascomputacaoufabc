// Generated from IsiLang.g4 by ANTLR 4.7.1
package br.com.professorisidro.isilanguage.parser;

	import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
	import br.com.professorisidro.isilanguage.datastructures.IsiVariable;
	import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
	import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
	import br.com.professorisidro.isilanguage.ast.IsiProgram;
	import br.com.professorisidro.isilanguage.ast.AbstractCommand;
	import br.com.professorisidro.isilanguage.ast.CommandLeitura;
	import br.com.professorisidro.isilanguage.ast.CommandEscrita;
	import br.com.professorisidro.isilanguage.ast.CommandAtribuicao;
	import br.com.professorisidro.isilanguage.ast.CommandDecisao;
	import br.com.professorisidro.isilanguage.ast.CommandRepeticao;
	import br.com.professorisidro.isilanguage.ast.CommandOpExp;
	import br.com.professorisidro.isilanguage.ast.CommandOpRaiz;
	import br.com.professorisidro.isilanguage.ast.CommandOpLog;
	import br.com.professorisidro.isilanguage.ast.CommandEscolha;
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.HashMap;
	import java.util.Map;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, AP=17, 
		FP=18, PT=19, COLON=20, SC=21, OP=22, ATTR=23, VIR=24, ACH=25, FCH=26, 
		OPREL=27, BOLEANO=28, ID=29, INT=30, NUMBER=31, WS=32, CARACTER=33, TEXTO=34, 
		OPEXP=35, OPRAIZ=36, OPLOG=37, COMENTLINHA=38, COMENTBLOCO=39;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_declaravar = 2, RULE_tipo = 3, RULE_bloco = 4, 
		RULE_cmd = 5, RULE_cmdleitura = 6, RULE_cmdescrita = 7, RULE_cmdattrib = 8, 
		RULE_cmdselecao = 9, RULE_cmdrepeticao = 10, RULE_cmdescolha = 11, RULE_expr = 12, 
		RULE_termo = 13;
	public static final String[] ruleNames = {
		"prog", "decl", "declaravar", "tipo", "bloco", "cmd", "cmdleitura", "cmdescrita", 
		"cmdattrib", "cmdselecao", "cmdrepeticao", "cmdescolha", "expr", "termo"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog;'", "'inteiro'", "'numero'", "'caractere'", 
		"'texto'", "'boleano'", "'leia'", "'escreva'", "'se'", "'senao'", "'enquanto'", 
		"'escolha'", "'caso'", "'break'", "'padrao'", "'('", "')'", "'.'", "':'", 
		"';'", null, "'='", "','", "'{'", "'}'", null, null, null, null, null, 
		null, null, null, null, "'#'", "'$'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "AP", "FP", "PT", "COLON", "SC", "OP", "ATTR", 
		"VIR", "ACH", "FCH", "OPREL", "BOLEANO", "ID", "INT", "NUMBER", "WS", 
		"CARACTER", "TEXTO", "OPEXP", "OPRAIZ", "OPLOG", "COMENTLINHA", "COMENTBLOCO"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		private int _tipo;
		private String _varName;
		private String _varValue;
		private IsiSymbolTable symbolTable = new IsiSymbolTable();
		private IsiSymbol symbol;
		private IsiProgram program = new IsiProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private ArrayList<AbstractCommand> listaTrue = new ArrayList<AbstractCommand>();
	    private ArrayList<AbstractCommand> listaFalse = new ArrayList<AbstractCommand>();

	    private Map<String, IsiVariable> varMap = new HashMap<String, IsiVariable>();
	    private IsiVariable varTemp;
	    private int termType;
	    private int tempVarType;
	    private String _exprRepeticao;
	    private ArrayList<AbstractCommand> instrucoes;
	    private String _exprSwitch;
	    private HashMap<String, ArrayList<AbstractCommand>> cases = new HashMap<String, ArrayList<AbstractCommand>>();
	    private ArrayList<String> caseCondition = new ArrayList<String>();
	    private ArrayList<AbstractCommand> defaultCase = new ArrayList<AbstractCommand>();

		private boolean isOpExp = false;
	    private boolean isOpRaiz = false;
	    private boolean isOpLog = false;
	    private String _caseCondition;
		
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new IsiSemanticException("Symbol "+id+" not declared");
			}
		}
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode(){
			program.generateTarget();
		}
		
		public void compatibilidadeTipos(int tipo1, String varName1, int tipo2, String varName2){
		    if(varMap.get(varName1) != null && varMap.get(varName2) != null && !varMap.get(varName2).getUsada()){
		        if((varMap.get(varName2)).getValue() == null){
	                throw new IsiSemanticException("Error: null exception, symbol ["+varName2+"] can not be assign to symbol ["+varName1 + "], because it is null.");
	            }
	            else{
	                (varMap.get(varName1)).setValue((varMap.get(varName2)).getValue());
	            }
		    }
			else if(((tipo1 != tipo2) && (tipo1 != 1 && tipo2 != 0))){
				throw new IsiSemanticException("Error: incompatible types, symbol ["+varName2+"] can not be assign to symbol ["+varName1 + "].");
			}
			else{
			    (varMap.get(varName1)).setValue(varName2);
			}
		
		}
		
		public void varDeclaradasNaoUsadas(){
			for (Map.Entry<String, IsiVariable> entry : varMap.entrySet()) {
				if(entry.getValue().getUsada() == false){
					System.out.println("WARNING: A variável ["+ entry.getKey() + "] foi declarada mas nunca é usada.");
				}
			}
		}
		
		public void setUsedVar(String nameID){
			varMap.get(nameID).setUsadaTT();
		}


	public IsiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			decl();
			setState(30);
			bloco();
			setState(31);
			match(T__1);
			  program.setVarTable(symbolTable);
			           	  program.setComandos(stack.pop());
			           	 
			           	 varDeclaradasNaoUsadas();
			           
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				declaravar();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaravarContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public List<TerminalNode> VIR() { return getTokens(IsiLangParser.VIR); }
		public TerminalNode VIR(int i) {
			return getToken(IsiLangParser.VIR, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			tipo();
			setState(40);
			match(ID);

				                  _varName = _input.LT(-1).getText();
				                  _varValue = null;
				                  symbol = new IsiVariable(_varName, _tipo, _varValue);

				                  varTemp = new IsiVariable(_varName, _tipo, _varValue);
				                  if (!symbolTable.exists(_varName)){
				                     symbolTable.add(symbol);	
				                     
				                     varMap.put(_varName, varTemp);
				                  }
				                  else{
				                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
				                  }
			                    
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIR) {
				{
				{
				setState(42);
				match(VIR);
				setState(43);
				match(ID);

					                  _varName = _input.LT(-1).getText();
					                  _varValue = null;
					                  symbol = new IsiVariable(_varName, _tipo, _varValue);
					                  
					                  varTemp = new IsiVariable(_varName, _tipo, _varValue);

					                  if (!symbolTable.exists(_varName)){
					                     symbolTable.add(symbol);	
					                     
					                      varMap.put(_varName, varTemp);
					                  }
					                  else{
					                  	 throw new IsiSemanticException("Symbol "+_varName+" already declared");
					                  }
				                    
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			match(SC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				match(T__2);
				 _tipo = IsiVariable.INT;  
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(T__3);
				 _tipo = IsiVariable.NUMBER;  
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				match(T__4);
				 _tipo = IsiVariable.CHAR;  
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(58);
				match(T__5);
				 _tipo = IsiVariable.TEXT;  
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 5);
				{
				setState(60);
				match(T__6);
				 _tipo = IsiVariable.BOOLEAN;  
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 curThread = new ArrayList<AbstractCommand>(); 
				        stack.push(curThread);  
			          
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65);
				cmd();
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdattribContext cmdattrib() {
			return getRuleContext(CmdattribContext.class,0);
		}
		public CmdselecaoContext cmdselecao() {
			return getRuleContext(CmdselecaoContext.class,0);
		}
		public CmdrepeticaoContext cmdrepeticao() {
			return getRuleContext(CmdrepeticaoContext.class,0);
		}
		public CmdescolhaContext cmdescolha() {
			return getRuleContext(CmdescolhaContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmd);
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				cmdleitura();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				cmdattrib();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				cmdselecao();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
				cmdrepeticao();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 6);
				{
				setState(75);
				cmdescolha();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__7);
			setState(79);
			match(AP);
			setState(80);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                     	  _readID = _input.LT(-1).getText();

			                     	  setUsedVar(_input.LT(-1).getText());
			                        
			setState(82);
			match(FP);
			setState(83);
			match(SC);

			              	IsiVariable var = (IsiVariable)symbolTable.get(_readID);
			              	CommandLeitura cmd = new CommandLeitura(_readID, var);
			              	stack.peek().add(cmd);
			              
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__8);
			setState(87);
			match(AP);
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(88);
				match(ID);
				 verificaID(_input.LT(-1).getText());
					                  _writeID = _input.LT(-1).getText();
				                     
				}
				break;
			case TEXTO:
				{
				setState(90);
				match(TEXTO);
				_writeID = _input.LT(-1).getText();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(94);
			match(FP);
			setState(95);
			match(SC);

			               	  CommandEscrita cmd = new CommandEscrita(_writeID);
			               	  stack.peek().add(cmd);
			               
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdattribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode ATTR() { return getToken(IsiLangParser.ATTR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SC() { return getToken(IsiLangParser.SC, 0); }
		public CmdattribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdattrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdattrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdattrib(this);
		}
	}

	public final CmdattribContext cmdattrib() throws RecognitionException {
		CmdattribContext _localctx = new CmdattribContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdattrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(ID);
			 verificaID(_input.LT(-1).getText());
			                    _exprID = _input.LT(-1).getText();

			                    tempVarType = varMap.get(_input.LT(-1).getText()).getType();
			                    setUsedVar(_input.LT(-1).getText());
			                   
			setState(100);
			match(ATTR);
			 _exprContent = ""; 
			setState(102);
			expr();

			               compatibilidadeTipos(tempVarType, _exprID, termType, _input.LT(-1).getText());
			               
			setState(104);
			match(SC);

			                 if (_exprContent.equals("verdadeiro")){
			                    _exprContent = "true";
			                 } else if (_exprContent.equals("falso")){
			                    _exprContent = "false";
			                 }
			               	 CommandAtribuicao cmd = new CommandAtribuicao(_exprID, _exprContent);
			               	 stack.peek().add(cmd);
			               
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdselecaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<TerminalNode> ACH() { return getTokens(IsiLangParser.ACH); }
		public TerminalNode ACH(int i) {
			return getToken(IsiLangParser.ACH, i);
		}
		public List<TerminalNode> FCH() { return getTokens(IsiLangParser.FCH); }
		public TerminalNode FCH(int i) {
			return getToken(IsiLangParser.FCH, i);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(IsiLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(IsiLangParser.NUMBER, i);
		}
		public List<TerminalNode> INT() { return getTokens(IsiLangParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(IsiLangParser.INT, i);
		}
		public List<TerminalNode> CARACTER() { return getTokens(IsiLangParser.CARACTER); }
		public TerminalNode CARACTER(int i) {
			return getToken(IsiLangParser.CARACTER, i);
		}
		public List<TerminalNode> BOLEANO() { return getTokens(IsiLangParser.BOLEANO); }
		public TerminalNode BOLEANO(int i) {
			return getToken(IsiLangParser.BOLEANO, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdselecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdselecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdselecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdselecao(this);
		}
	}

	public final CmdselecaoContext cmdselecao() throws RecognitionException {
		CmdselecaoContext _localctx = new CmdselecaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdselecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__9);
			setState(108);
			match(AP);
			setState(109);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOLEANO) | (1L << ID) | (1L << INT) | (1L << NUMBER) | (1L << CARACTER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			 _exprDecision = _input.LT(-1).getText(); 
			setState(111);
			match(OPREL);
			 _exprDecision += _input.LT(-1).getText(); 
			setState(113);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOLEANO) | (1L << ID) | (1L << INT) | (1L << NUMBER) | (1L << CARACTER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			_exprDecision += _input.LT(-1).getText(); 
			setState(115);
			match(FP);
			setState(116);
			match(ACH);
			 curThread = new ArrayList<AbstractCommand>();
			                      stack.push(curThread);
			                    
			setState(119); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(118);
				cmd();
				}
				}
				setState(121); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << ID))) != 0) );
			setState(123);
			match(FCH);

			                       listaTrue = stack.pop();
			                    
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(125);
				match(T__10);
				setState(126);
				match(ACH);

				                   	 	curThread = new ArrayList<AbstractCommand>();
				                   	 	stack.push(curThread);
				                   	 
				{
				setState(129); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(128);
					cmd();
					}
					}
					setState(131); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << ID))) != 0) );
				}
				setState(133);
				match(FCH);

				                   		listaFalse = stack.pop();

				                   	
				}
			}


			                     CommandDecisao cmd = new CommandDecisao(_exprDecision, listaTrue, listaFalse);
			                     stack.peek().add(cmd);
			                   
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdrepeticaoContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode OPREL() { return getToken(IsiLangParser.OPREL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(IsiLangParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(IsiLangParser.NUMBER, i);
		}
		public List<TerminalNode> INT() { return getTokens(IsiLangParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(IsiLangParser.INT, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdrepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdrepeticao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdrepeticao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdrepeticao(this);
		}
	}

	public final CmdrepeticaoContext cmdrepeticao() throws RecognitionException {
		CmdrepeticaoContext _localctx = new CmdrepeticaoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdrepeticao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__11);
			setState(141);
			match(AP);
			setState(142);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INT) | (1L << NUMBER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			 _exprRepeticao = _input.LT(-1).getText(); 
			setState(144);
			match(OPREL);
			 _exprRepeticao += _input.LT(-1).getText(); 
			setState(146);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << INT) | (1L << NUMBER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			_exprRepeticao += _input.LT(-1).getText(); 
			setState(148);
			match(FP);
			setState(149);
			match(ACH);

			                           curThread = new ArrayList<AbstractCommand>();
			                      	   stack.push(curThread);
			                    	 
			setState(152); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(151);
				cmd();
				}
				}
				setState(154); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << ID))) != 0) );
			setState(156);
			match(FCH);

			                            instrucoes = stack.pop();
			                    	    CommandRepeticao cmd = new CommandRepeticao(_exprRepeticao, instrucoes);
			                   		    stack.peek().add(cmd);
			                   	     
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdescolhaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode ACH() { return getToken(IsiLangParser.ACH, 0); }
		public TerminalNode FCH() { return getToken(IsiLangParser.FCH, 0); }
		public List<TerminalNode> COLON() { return getTokens(IsiLangParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(IsiLangParser.COLON, i);
		}
		public List<TerminalNode> SC() { return getTokens(IsiLangParser.SC); }
		public TerminalNode SC(int i) {
			return getToken(IsiLangParser.SC, i);
		}
		public List<TerminalNode> INT() { return getTokens(IsiLangParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(IsiLangParser.INT, i);
		}
		public List<TerminalNode> CARACTER() { return getTokens(IsiLangParser.CARACTER); }
		public TerminalNode CARACTER(int i) {
			return getToken(IsiLangParser.CARACTER, i);
		}
		public List<TerminalNode> TEXTO() { return getTokens(IsiLangParser.TEXTO); }
		public TerminalNode TEXTO(int i) {
			return getToken(IsiLangParser.TEXTO, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdescolhaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescolha; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdescolha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdescolha(this);
		}
	}

	public final CmdescolhaContext cmdescolha() throws RecognitionException {
		CmdescolhaContext _localctx = new CmdescolhaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdescolha);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__12);
			setState(160);
			match(AP);
			setState(161);
			match(ID);

			                             _exprSwitch = _input.LT(-1).getText();
			                           
			setState(163);
			match(FP);
			setState(164);
			match(ACH);
			setState(186); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(165);
				match(T__13);
				setState(172);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INT:
					{
					setState(166);
					match(INT);

					                                 _exprContent = _input.LT(-1).getText();
					                                 termType = 0;
					                                
					}
					break;
				case CARACTER:
					{
					setState(168);
					match(CARACTER);

					                                         _exprContent = _input.LT(-1).getText();
					                                         termType = 2;
					                                       
					}
					break;
				case TEXTO:
					{
					setState(170);
					match(TEXTO);

					                                      _exprContent = _input.LT(-1).getText();
					                                      termType = 3;
					                                     
					}
					break;
				default:
					throw new NoViableAltException(this);
				}

				                             compatibilidadeTipos(varMap.get(_exprSwitch).getType(), _exprSwitch, termType, _exprContent);
				                             _caseCondition = _exprContent;
				                             caseCondition.add(_caseCondition);
				                           
				setState(175);
				match(COLON);

				                            curThread = new ArrayList<AbstractCommand>();
				                            stack.push(curThread);
				                          
				{
				setState(178); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(177);
					cmd();
					}
					}
					setState(180); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << ID))) != 0) );
				}
				setState(182);
				match(T__14);
				setState(183);
				match(SC);

				                            cases.put(_caseCondition,stack.pop());
				                          
				}
				}
				setState(188); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__13 );
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(190);
				match(T__15);
				setState(191);
				match(COLON);

				                            curThread = new ArrayList<AbstractCommand>();
				                            stack.push(curThread);
				                           
				{
				setState(194); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(193);
					cmd();
					}
					}
					setState(196); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__12) | (1L << ID))) != 0) );
				}

				                            defaultCase = stack.pop();
				                           
				}
			}

			setState(202);
			match(FCH);

			                            CommandEscolha cmd = new CommandEscolha(_exprSwitch, caseCondition, cases, defaultCase);
			                            stack.peek().add(cmd);
			                        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public TerminalNode OPEXP() { return getToken(IsiLangParser.OPEXP, 0); }
		public TerminalNode OPLOG() { return getToken(IsiLangParser.OPLOG, 0); }
		public TerminalNode OPRAIZ() { return getToken(IsiLangParser.OPRAIZ, 0); }
		public List<TerminalNode> OP() { return getTokens(IsiLangParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(IsiLangParser.OP, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			termo();
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SC:
			case OP:
				{
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP) {
					{
					{
					setState(206);
					match(OP);
					 _exprContent += _input.LT(-1).getText();
					setState(208);
					termo();
					}
					}
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case OPEXP:
				{
				setState(214);
				match(OPEXP);
				 _exprContent += " ";
				                        _exprContent += _input.LT(-1).getText();
				                        _exprContent += " ";
				                        isOpExp=true;
				                        
				setState(216);
				termo();
				}
				break;
			case OPLOG:
				{
				setState(217);
				match(OPLOG);
				 _exprContent += " ";
				                            _exprContent += _input.LT(-1).getText();
				                            _exprContent += " ";
				                            isOpLog=true;
				                            
				setState(219);
				termo();
				}
				break;
			case OPRAIZ:
				{
				setState(220);
				match(OPRAIZ);
				_exprContent += " ";
				                 	_exprContent += _input.LT(-1).getText();
				                     isOpRaiz=true;
				                 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			                    if(isOpExp) {
			                        CommandOpExp cmd = new CommandOpExp(_exprContent);
			                        _exprContent = cmd.generateJavaCode();
			                        isOpExp=false;
			                    }
			                    else if(isOpLog) {
			                         CommandOpLog cmd = new CommandOpLog(_exprContent);
			                         _exprContent = cmd.generateJavaCode();
			                         isOpLog=false;
			                    }
			                    else if(isOpRaiz) {
			                        CommandOpRaiz cmd = new CommandOpRaiz(_exprContent);
			                        _exprContent = cmd.generateJavaCode();
			                        isOpRaiz=false;
			                    }
			                
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode INT() { return getToken(IsiLangParser.INT, 0); }
		public TerminalNode NUMBER() { return getToken(IsiLangParser.NUMBER, 0); }
		public TerminalNode CARACTER() { return getToken(IsiLangParser.CARACTER, 0); }
		public TerminalNode TEXTO() { return getToken(IsiLangParser.TEXTO, 0); }
		public TerminalNode BOLEANO() { return getToken(IsiLangParser.BOLEANO, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_termo);
		try {
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				match(ID);

				                 verificaID(_input.LT(-1).getText());
					             _exprContent += _input.LT(-1).getText();
				               
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				match(INT);

				                 _exprContent += _input.LT(-1).getText();
				                 termType = 0;
				               
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(230);
				match(NUMBER);

				              	_exprContent += _input.LT(-1).getText();
				              	termType = 1;
				              
				}
				break;
			case CARACTER:
				enterOuterAlt(_localctx, 4);
				{
				setState(232);
				match(CARACTER);

				                _exprContent += _input.LT(-1).getText();
				                termType = 2;
				              
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 5);
				{
				setState(234);
				match(TEXTO);

				                _exprContent += _input.LT(-1).getText();
				                termType = 3;
				              
				}
				break;
			case BOLEANO:
				enterOuterAlt(_localctx, 6);
				{
				setState(236);
				match(BOLEANO);

				                _exprContent += _input.LT(-1).getText();
				                termType = 4;
				              
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00f3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\2\3\2\3\3\6"+
		"\3&\n\3\r\3\16\3\'\3\4\3\4\3\4\3\4\3\4\3\4\7\4\60\n\4\f\4\16\4\63\13\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5A\n\5\3\6\3\6\6\6"+
		"E\n\6\r\6\16\6F\3\7\3\7\3\7\3\7\3\7\3\7\5\7O\n\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t_\n\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\6\13z\n\13\r\13\16\13{\3\13\3\13\3\13\3\13\3\13\3\13\6"+
		"\13\u0084\n\13\r\13\16\13\u0085\3\13\3\13\3\13\5\13\u008b\n\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u009b\n\f\r\f"+
		"\16\f\u009c\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\5\r\u00af\n\r\3\r\3\r\3\r\3\r\6\r\u00b5\n\r\r\r\16\r\u00b6\3\r"+
		"\3\r\3\r\3\r\6\r\u00bd\n\r\r\r\16\r\u00be\3\r\3\r\3\r\3\r\6\r\u00c5\n"+
		"\r\r\r\16\r\u00c6\3\r\3\r\5\r\u00cb\n\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\7\16\u00d4\n\16\f\16\16\16\u00d7\13\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u00e1\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u00f1\n\17\3\17\2\2\20\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\2\4\4\2\36!##\3\2\37!\2\u0104\2\36\3\2\2\2\4%\3\2\2"+
		"\2\6)\3\2\2\2\b@\3\2\2\2\nB\3\2\2\2\fN\3\2\2\2\16P\3\2\2\2\20X\3\2\2\2"+
		"\22d\3\2\2\2\24m\3\2\2\2\26\u008e\3\2\2\2\30\u00a1\3\2\2\2\32\u00cf\3"+
		"\2\2\2\34\u00f0\3\2\2\2\36\37\7\3\2\2\37 \5\4\3\2 !\5\n\6\2!\"\7\4\2\2"+
		"\"#\b\2\1\2#\3\3\2\2\2$&\5\6\4\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3"+
		"\2\2\2(\5\3\2\2\2)*\5\b\5\2*+\7\37\2\2+\61\b\4\1\2,-\7\32\2\2-.\7\37\2"+
		"\2.\60\b\4\1\2/,\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64"+
		"\3\2\2\2\63\61\3\2\2\2\64\65\7\27\2\2\65\7\3\2\2\2\66\67\7\5\2\2\67A\b"+
		"\5\1\289\7\6\2\29A\b\5\1\2:;\7\7\2\2;A\b\5\1\2<=\7\b\2\2=A\b\5\1\2>?\7"+
		"\t\2\2?A\b\5\1\2@\66\3\2\2\2@8\3\2\2\2@:\3\2\2\2@<\3\2\2\2@>\3\2\2\2A"+
		"\t\3\2\2\2BD\b\6\1\2CE\5\f\7\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2"+
		"G\13\3\2\2\2HO\5\16\b\2IO\5\20\t\2JO\5\22\n\2KO\5\24\13\2LO\5\26\f\2M"+
		"O\5\30\r\2NH\3\2\2\2NI\3\2\2\2NJ\3\2\2\2NK\3\2\2\2NL\3\2\2\2NM\3\2\2\2"+
		"O\r\3\2\2\2PQ\7\n\2\2QR\7\23\2\2RS\7\37\2\2ST\b\b\1\2TU\7\24\2\2UV\7\27"+
		"\2\2VW\b\b\1\2W\17\3\2\2\2XY\7\13\2\2Y^\7\23\2\2Z[\7\37\2\2[_\b\t\1\2"+
		"\\]\7$\2\2]_\b\t\1\2^Z\3\2\2\2^\\\3\2\2\2_`\3\2\2\2`a\7\24\2\2ab\7\27"+
		"\2\2bc\b\t\1\2c\21\3\2\2\2de\7\37\2\2ef\b\n\1\2fg\7\31\2\2gh\b\n\1\2h"+
		"i\5\32\16\2ij\b\n\1\2jk\7\27\2\2kl\b\n\1\2l\23\3\2\2\2mn\7\f\2\2no\7\23"+
		"\2\2op\t\2\2\2pq\b\13\1\2qr\7\35\2\2rs\b\13\1\2st\t\2\2\2tu\b\13\1\2u"+
		"v\7\24\2\2vw\7\33\2\2wy\b\13\1\2xz\5\f\7\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2"+
		"\2{|\3\2\2\2|}\3\2\2\2}~\7\34\2\2~\u008a\b\13\1\2\177\u0080\7\r\2\2\u0080"+
		"\u0081\7\33\2\2\u0081\u0083\b\13\1\2\u0082\u0084\5\f\7\2\u0083\u0082\3"+
		"\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0088\7\34\2\2\u0088\u0089\b\13\1\2\u0089\u008b\3"+
		"\2\2\2\u008a\177\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008d\b\13\1\2\u008d\25\3\2\2\2\u008e\u008f\7\16\2\2\u008f\u0090\7\23"+
		"\2\2\u0090\u0091\t\3\2\2\u0091\u0092\b\f\1\2\u0092\u0093\7\35\2\2\u0093"+
		"\u0094\b\f\1\2\u0094\u0095\t\3\2\2\u0095\u0096\b\f\1\2\u0096\u0097\7\24"+
		"\2\2\u0097\u0098\7\33\2\2\u0098\u009a\b\f\1\2\u0099\u009b\5\f\7\2\u009a"+
		"\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2"+
		"\2\2\u009d\u009e\3\2\2\2\u009e\u009f\7\34\2\2\u009f\u00a0\b\f\1\2\u00a0"+
		"\27\3\2\2\2\u00a1\u00a2\7\17\2\2\u00a2\u00a3\7\23\2\2\u00a3\u00a4\7\37"+
		"\2\2\u00a4\u00a5\b\r\1\2\u00a5\u00a6\7\24\2\2\u00a6\u00bc\7\33\2\2\u00a7"+
		"\u00ae\7\20\2\2\u00a8\u00a9\7 \2\2\u00a9\u00af\b\r\1\2\u00aa\u00ab\7#"+
		"\2\2\u00ab\u00af\b\r\1\2\u00ac\u00ad\7$\2\2\u00ad\u00af\b\r\1\2\u00ae"+
		"\u00a8\3\2\2\2\u00ae\u00aa\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\u00b1\b\r\1\2\u00b1\u00b2\7\26\2\2\u00b2\u00b4\b\r\1\2\u00b3"+
		"\u00b5\5\f\7\2\u00b4\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b4\3\2"+
		"\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\7\21\2\2\u00b9"+
		"\u00ba\7\27\2\2\u00ba\u00bb\b\r\1\2\u00bb\u00bd\3\2\2\2\u00bc\u00a7\3"+
		"\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\u00ca\3\2\2\2\u00c0\u00c1\7\22\2\2\u00c1\u00c2\7\26\2\2\u00c2\u00c4\b"+
		"\r\1\2\u00c3\u00c5\5\f\7\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00c9\b\r"+
		"\1\2\u00c9\u00cb\3\2\2\2\u00ca\u00c0\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00cd\7\34\2\2\u00cd\u00ce\b\r\1\2\u00ce\31\3\2\2"+
		"\2\u00cf\u00e0\5\34\17\2\u00d0\u00d1\7\30\2\2\u00d1\u00d2\b\16\1\2\u00d2"+
		"\u00d4\5\34\17\2\u00d3\u00d0\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3\3"+
		"\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00e1\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8"+
		"\u00d9\7%\2\2\u00d9\u00da\b\16\1\2\u00da\u00e1\5\34\17\2\u00db\u00dc\7"+
		"\'\2\2\u00dc\u00dd\b\16\1\2\u00dd\u00e1\5\34\17\2\u00de\u00df\7&\2\2\u00df"+
		"\u00e1\b\16\1\2\u00e0\u00d5\3\2\2\2\u00e0\u00d8\3\2\2\2\u00e0\u00db\3"+
		"\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\b\16\1\2\u00e3"+
		"\33\3\2\2\2\u00e4\u00e5\7\37\2\2\u00e5\u00f1\b\17\1\2\u00e6\u00e7\7 \2"+
		"\2\u00e7\u00f1\b\17\1\2\u00e8\u00e9\7!\2\2\u00e9\u00f1\b\17\1\2\u00ea"+
		"\u00eb\7#\2\2\u00eb\u00f1\b\17\1\2\u00ec\u00ed\7$\2\2\u00ed\u00f1\b\17"+
		"\1\2\u00ee\u00ef\7\36\2\2\u00ef\u00f1\b\17\1\2\u00f0\u00e4\3\2\2\2\u00f0"+
		"\u00e6\3\2\2\2\u00f0\u00e8\3\2\2\2\u00f0\u00ea\3\2\2\2\u00f0\u00ec\3\2"+
		"\2\2\u00f0\u00ee\3\2\2\2\u00f1\35\3\2\2\2\24\'\61@FN^{\u0085\u008a\u009c"+
		"\u00ae\u00b6\u00be\u00c6\u00ca\u00d5\u00e0\u00f0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}