/* Robot.java */
/* Generated By:JavaCC: Do not edit this line. Robot.java */
package uniandes.lym.robot.control;

import uniandes.lym.robot.kernel.*;
import uniandes.lym.robot.view.Console;

import java.awt.Point;
import java.io.*;
import java.util.Vector;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class Robot implements RobotConstants {



        private RobotWorldDec world;

        private Map <String, Integer> variables = new HashMap <String, Integer >();


        void setWorld(RobotWorld w) {
                world = (RobotWorldDec) w;
        }

        String salida=new String();

        public boolean var(String name)
        {
                if (variables.containsKey(name)) {
                  return true;
        }
        else {
          return false;
        }
}

        public Integer varValue(String name) {
          Integer respuesta = variables.get(name);

          return respuesta;
        }

        public void saveVar (String name, Integer value) {
                variables.put(name, value);
        }

//boolean command(uniandes.lym.robot.view.Console sistema) :
        /*boolean command(Console sistema):
	{	
		
		int x,y;
		salida=new String();	
	}

	
	{
		(		  (
		   <RIGHT> "(" ")" {world.turnRight();salida = "Command: Turnright";}
		| 	<MOV>  "(" x=num() ")" {world.moveForward(x,false);salida = "Command: Moveforward ";}  
		| 	<HOP>  "(" x=num() ")" {world.moveForward(x,true);salida = "Command:Jumpforward ";}
		| 	<GO>  "(" x=num() "," y=num()")" {world.setPostion(x,y);salida = "Command:GO ";}  
		|  <PUT> "("  put() ")"					  			
		|  <PICK> "(" get()  ")"	
	    |  < POP > "(" x=num() ")" {world.popBalloons(x); salida = "Comando:  Pop";}
		) ";" 

		{
		    try {
	    			 Thread.sleep(900);
	    	    } catch (InterruptedException e) {
	    			        System.err.format("IOException: %s%n", e);
	    		    }
	    			 
			sistema.printOutput(salida);
			return true;
		})+

    	| <EOF> {return false;} 
	}

	void put() :
	{
		int f=1;	
	}
	{
		( <CHIPS>    "," f=num() {world.putChips(f); salida = "Command:  Put Chips"; })
		|  	  ( <BALLOONS>   "," f=num() {world.putBalloons(f); salida = "Command:  Put Balloons";})	 

	}

	void get() :
	{
		int f=1;	
	}
	{
		( <CHIPS>   "," f=num() {world.pickChips(f);salida = "Command:  Pick chips";})
		|  	  ( <BALLOONS>   "," f=num() {world.grabBalloons(f);salida="Command:  Pick balloons";})	 

	} */

/* aqui inician las de nuestro proyecto */
  final public 
        void command() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case WALK:
    case TURN:
    case LEAP:
    case TURNTO:
    case DROP:
    case GET:
    case GRAB:
    case LETGO:
    case NOP:
    case JUMP:{
      simpleCommands();
      break;
      }
    case 38:{
      block();
      break;
      }
    case DEFVAR:{
      defVar();
      break;
      }
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void block() throws ParseException {
    jj_consume_token(38);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case WALK:
    case TURN:
    case LEAP:
    case TURNTO:
    case DROP:
    case GET:
    case GRAB:
    case LETGO:
    case NOP:
    case JUMP:{
      simpleCommands();
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case 39:{
          ;
          break;
          }
        default:
          jj_la1[1] = jj_gen;
          break label_1;
        }
        jj_consume_token(39);
        simpleCommands();
      }
      break;
      }
    case IF:
    case WHILE:
    case REPEAT:{
      cycle();
      break;
      }
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(40);
}

  final public void simpleCommands() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case JUMP:{
      jump();
      break;
      }
    case WALK:{
      walk();
      break;
      }
    case LEAP:{
      leap();
      break;
      }
    case TURN:{
      turn();
      break;
      }
    case TURNTO:{
      turnto();
      break;
      }
    case DROP:
    case GET:
    case GRAB:
    case LETGO:{
      move();
      break;
      }
    case NOP:{
      jj_consume_token(NOP);
      jj_consume_token(41);
      jj_consume_token(42);
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void walk() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case WALK:{
      jj_consume_token(WALK);
      jj_consume_token(41);
      f = num();
      jj_consume_token(42);
      break;
      }{
      jj_consume_token(WALK);
      jj_consume_token(41);
      f = num();
      jj_consume_token(43);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case FRONT:
      case BACK:
      case RIGHT:
      case LEFT:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case FRONT:{
          jj_consume_token(FRONT);
          break;
          }
        case RIGHT:{
          jj_consume_token(RIGHT);
          break;
          }
        case LEFT:{
          jj_consume_token(LEFT);
          break;
          }
        case BACK:{
          jj_consume_token(BACK);
          break;
          }
        default:
          jj_la1[4] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case SOUTH:
      case NORTH:
      case EAST:
      case WEST:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case NORTH:{
          jj_consume_token(NORTH);
          break;
          }
        case SOUTH:{
          jj_consume_token(SOUTH);
          break;
          }
        case EAST:{
          jj_consume_token(EAST);
          break;
          }
        case WEST:{
          jj_consume_token(WEST);
          break;
          }
        default:
          jj_la1[5] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(42);
      break;
      }
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void leap() throws ParseException {
    jj_consume_token(LEAP);
    jj_consume_token(41);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case NUM:{
      f = num();
      jj_consume_token(42);
      break;
      }
    case LEAP:{
      jj_consume_token(LEAP);
      jj_consume_token(41);
      f = num();
      jj_consume_token(43);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case FRONT:
      case BACK:
      case RIGHT:
      case LEFT:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case FRONT:{
          jj_consume_token(FRONT);
          break;
          }
        case RIGHT:{
          jj_consume_token(RIGHT);
          break;
          }
        case LEFT:{
          jj_consume_token(LEFT);
          break;
          }
        case BACK:{
          jj_consume_token(BACK);
          break;
          }
        default:
          jj_la1[8] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      case SOUTH:
      case NORTH:
      case EAST:
      case WEST:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case NORTH:{
          jj_consume_token(NORTH);
          break;
          }
        case SOUTH:{
          jj_consume_token(SOUTH);
          break;
          }
        case EAST:{
          jj_consume_token(EAST);
          break;
          }
        case WEST:{
          jj_consume_token(WEST);
          break;
          }
        default:
          jj_la1[9] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
        }
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(42);
}

  final public void jump() throws ParseException {
    jj_consume_token(JUMP);
    jj_consume_token(41);
    f = num();
    jj_consume_token(43);
    g = num();
    jj_consume_token(42);
}

  final public void turn() throws ParseException {
    jj_consume_token(TURN);
    jj_consume_token(41);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case LEFT:{
      jj_consume_token(LEFT);
      break;
      }
    case RIGHT:{
      jj_consume_token(RIGHT);
      break;
      }
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(42);
}

  final public void turnto() throws ParseException {
    jj_consume_token(TURNTO);
    jj_consume_token(41);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case NORTH:{
      jj_consume_token(NORTH);
      break;
      }
    case SOUTH:{
      jj_consume_token(SOUTH);
      break;
      }
    case EAST:{
      jj_consume_token(EAST);
      break;
      }
    case WEST:{
      jj_consume_token(WEST);
      break;
      }
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(42);
}

  final public void move() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case DROP:{
      jj_consume_token(DROP);
      jj_consume_token(41);
      f = num();
      jj_consume_token(42);
      break;
      }
    case GET:{
      jj_consume_token(GET);
      jj_consume_token(41);
      f = num();
      jj_consume_token(42);
      break;
      }
    case GRAB:{
      jj_consume_token(GRAB);
      jj_consume_token(41);
      f = num();
      jj_consume_token(42);
      break;
      }
    case LETGO:{
      jj_consume_token(LETGO);
      jj_consume_token(41);
      f = num();
      jj_consume_token(42);
      break;
      }
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public void defVar() throws ParseException {
    jj_consume_token(DEFVAR);
    function = name();
    jj_consume_token(44);
    f = num();
{
                      saveVar(function, f);
                    }
}

  final public void defProc() throws ParseException {
    jj_consume_token(DEFPROC);
    jj_consume_token(NAME);
    jj_consume_token(41);
    jj_consume_token(NAME);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case 43:{
        ;
        break;
        }
      default:
        jj_la1[15] = jj_gen;
        break label_2;
      }
      jj_consume_token(43);
      jj_consume_token(NAME);
    }
    jj_consume_token(42);
    block();
}

  final public void cycle() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IF:{
      jj_consume_token(IF);
      jj_consume_token(41);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case NOT:{
        not();
        break;
        }
      case CAN:{
        can();
        break;
        }
      case FACING:{
        facing();
        break;
        }
      default:
        jj_la1[16] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(42);
      block();
      jj_consume_token(ELSE);
      block();
      break;
      }
    case WHILE:{
      jj_consume_token(WHILE);
      jj_consume_token(41);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case NOT:{
        not();
        break;
        }
      case CAN:{
        can();
        break;
        }
      case FACING:{
        facing();
        break;
        }
      default:
        jj_la1[17] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(42);
      block();
      break;
      }
    case REPEAT:{
      jj_consume_token(REPEAT);
      f = num();
      jj_consume_token(TIMES);
      block();
      break;
      }
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
}

  final public boolean not() throws ParseException {
    jj_consume_token(NOT);
    jj_consume_token(45);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case CAN:{
      can();
      break;
      }
    case FACING:{
      facing();
      break;
      }
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
try {
                                    int a = 1; /*aqui debe hacer el codigo para que intente o verifique lo que esta ahí*/
                                } catch (InterruptedException e) {
                                                                System.err.format("IOException: %s%n", e);
                                                    }
}

  final public boolean can() throws ParseException {
    jj_consume_token(CAN);
    jj_consume_token(41);
    simpleCommands();
    jj_consume_token(42);
try {
                                    int a = 1; /*aqui debe hacer el codigo para que intente o verifique lo que esta ahí*/
                                } catch (InterruptedException e) {
                                                                System.err.format("IOException: %s%n", e);
                                                    }
}

  final public boolean facing() throws ParseException {
    jj_consume_token(FACING);
    jj_consume_token(41);
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case NORTH:{
      jj_consume_token(NORTH);
      break;
      }
    case SOUTH:{
      jj_consume_token(SOUTH);
      break;
      }
    case WEST:{
      jj_consume_token(WEST);
      break;
      }
    case EAST:{
      jj_consume_token(EAST);
      break;
      }
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    jj_consume_token(42);
try {
                                    int a = 1; /*aqui debe hacer el codigo para que intente o verifique lo que esta ahí*/
                                } catch (InterruptedException e) {
                                                                System.err.format("IOException: %s%n", e);
                                                    }
}

/**
	 * Unsigned decimal number
	 * @return the corresponding value of the string
	 * @error  corresponding value is too large
	 */
  final public 
        String name() throws ParseException, Error {Token token;
    token = jj_consume_token(NAME);
{if ("" != null) return token.image;}
    throw new Error("Missing return statement in function");
}

  final public int num() throws ParseException, Error {int total=1;
    jj_consume_token(NUM);
try
                        {
                                total = Integer.parseInt(token.image);
                        }
                        catch (NumberFormatException ee)
                        {
                                {if (true) throw new Error("Number out of bounds: "+token.image+" !!");}
                        }
                        {if ("" != null) return total;}
    throw new Error("Missing return statement in function");
}

  final public int variable() throws ParseException {Token token;
    name = name();
{if ("" != null) return varValue(name);}
    throw new Error("Missing return statement in function");
}

  /** Generated Token Manager. */
  public RobotTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[21];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x1fee0,0x0,0x34fee0,0xfee0,0xc0000000,0x3c000000,0xfc000000,0x20,0xc0000000,0x3c000000,0xfc000000,0x80,0x0,0x3c000000,0x3c00,0x0,0x3800000,0x3800000,0x340000,0x1800000,0x3c000000,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x40,0x80,0x0,0x0,0x3,0x0,0x3,0x0,0x3,0x0,0x3,0x4,0x3,0x0,0x0,0x800,0x0,0x0,0x0,0x0,0x0,};
	}

  /** Constructor with InputStream. */
  public Robot(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Robot(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new RobotTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Robot(java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new RobotTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new RobotTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Robot(RobotTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(RobotTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 21; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[46];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 21; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 46; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
