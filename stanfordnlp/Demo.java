package stanfordnlp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;

import DrawTree.TreePanel;
import edu.stanford.nlp.coref.CorefCoreAnnotations;
import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.io.EncodingPrintWriter;
import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.process.WordToSentenceProcessor.NewlineIsSentenceBreak;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;
import mainPro.NumUtil;

public class Demo extends JFrame{
	
	
	
	
	/** 
	 * @see node_depth閿熼ズ鎲嬫嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鑺備紮鎷烽敓鏂ゆ嫹閿熸枻娉曢敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
	 * @param store_node_weigh,store_node_depth 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓浠嬶紝涓�閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓楗猴綇鎷蜂竴閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿燂拷
	 */  
	public static String natural_language;
	public static int node_depth = 10;
	public static int node_weigh = 10;
	public static int pre_node_depth = 10;
	public static int[] store_node_depth = new int[400];
	public static int[] store_node_weigh = new int[400];
	public static String[] store_node_label = new String[400];
	public static int count = 0;
	
	/** 
	 * @see 閿熸枻鎷烽敓钘夋瀯閿熷眾鍑介敓鏂ゆ嫹,閿熸枻鎷烽敓鏂ゆ嫹MainProl閿熸枻鎷风墶閿熸枻鎷烽敓锟�*************************************************
	 * 
	 */  
	
	public Demo(String mianpro_natural_language)
	{
		natural_language = mianpro_natural_language;
	}
	
	/** 
	 * @see 榛橀敓杈冪櫢鎷烽敓灞婂嚱閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹formulaParser閿熶茎纰夋嫹閿熸枻鎷�***********************************************8
	 * 
	 */
	
	public Demo()
	{
		
	}
	
	
	
	
	
	
	
	
	public static InputStream  toStanfordmark(String  sargs) throws IOException {
        // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution
		
		
//		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//	        String line = reader.readLine();
		
		 String line = sargs;
		
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
         
        
        
        /***
		 * 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓渚ョ殑璁规嫹閿熻棄鏂归敓鏂ゆ嫹涓�
		 * 
		 	String props="StanfordCoreNLP-chinese.properties";
		 	StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		 *閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熺殕鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹natural_language閿熶茎纰夋嫹涓�閿熸枻鎷烽敓琛楀嚖鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鍙柇锝忔嫹涓洪敓鏂ゆ嫹姣嶉敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹鑻遍敓鏂ゆ嫹璇嗛敓鏂ゆ嫹
		 *涓洪敓鏂ゆ嫹閿熻鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷疯瘑閿熸枻鎷�(閿熸枻鎷烽敓鏂ゆ嫹閿燂拷)
		 */
 /////////////////////////////////////////////////////////////////////////////////////
        
//		 String props="StanfordCoreNLP-chinese.properties";
//		 StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        
        
/////////////////////////////////////////////////////////////////////////////////////
        
        
        
        
        
        
        
        
        // read some text in the text variable
        String text =line;
        
        /**
         * 閿熸枻鎷烽敓琛楄揪鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹Bug r_7閿熺潾鍑ゆ嫹璇嗛敓鏂ゆ嫹
         * 
         * */
       // NumUtil NumUtil_object = new NumUtil();
        //text = NumUtil_object.getNumeric(line);
        
        /**
         * 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
         * 
         * */
        
        text = rearrange(text);
        
        System.out.println("Demo閿熸枻鎷烽敓鏂ゆ嫹閿熺但ext閿熸枻鎷峰�间负"+text);
        //String text ="If voter initiates voting action and voter has vote,  voter must vote successfully at all times ;" ;//when gasconcentration exceed 10%,alarm should be activated until  gasconcentration is below 8%;
        
//        Scanner scanner = new Scanner(inputStream, "UTF-8");
//        String text = scanner.useDelimiter("\\A").next();
        // create an empty Annotation just with the given text
        /**
         * 
         * 2-22閿熸枻鎷烽敓鏂ゆ嫹閿熶茎纰夋嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
         * 
         * */
        
        String poss="";
        String s="";
        
        String stringSentence ="";
        
        String huanyuan="";
        String file_string="";
        
        InputStream pptlInPutStream= null;
        

        Annotation document = new Annotation(text);

        // run all Annotators on this text
        pipeline.annotate(document);
        
        String result="";



        // these are all the sentences in this document
// a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        
        

        
        System.out.println("word\tpos\tlemma\tner");
        for(CoreMap sentence: sentences) {
             // traversing the words in the current sentence
             // a CoreLabel is a CoreMap with additional token-specific methods
            for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                // this is the text of the token
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                // this is the POS tag of the token
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                // this is the NER label of the token
                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
                poss+=pos+" ";
                huanyuan+=lemma+" ";
            	/** 
            	 * 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷锋棷銈忔嫹閿熸枻鎷烽敓琛楁唻鎷风‖閿熸枻鎷烽敓楗衡槄鎷烽敓鏂ゆ嫹鑾搁敓鏂ゆ嫹閿熸枻鎷烽敓鎻鎷烽敓瑙掞拷***********************************************8
            	 * 
            	 */
                
                if(!(word.equals(",")||word.equals(";")||word.equals("%")||word.equals(".")))
                {
                	s+=pos+" "+word+" ";
                }else
                {
                	 s+=" "+word;
                }
               
                System.out.println(word+"\t"+pos+"\t"+lemma+"\t"+ne);
            }
            System.out.println(poss);
            System.out.println(s);
            System.out.println(huanyuan);
            
            
            Tree tree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
            System.out.println(String.format("tree:\n%s",tree.toString()));
            Tree[] treeChildren =tree.children();
            System.out.println("閿熸枻鎷烽敓渚ョ鎷蜂竴閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓瑙掔殑璁规嫹閿熻淇濊揪鎷烽敓鏂ゆ嫹treeChildree"+treeChildren.toString());
            
            //String s1 = "WRB When DT an NN anchor NN vehicle VBZ appears  ,DT the NN system VBZ sets NN five .";
            
            //pptlInPutStream = new ByteArrayInputStream(stringSentence.getBytes());
           // s = "Start monitoring with DT the NN dog VB run, End monitoring with DT the NN bird VB fly.";

        }

/***********
 * 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓渚ヤ紮鎷锋垂锝忔嫹閿燂拷
 * *        
 */
        
//        String s1 = new String(s.getBytes("UTF-8"),"UTF-8");
//        pptlInPutStream = new ByteArrayInputStream(s1.getBytes("UTF-8"));
//      String s1 = new String(s.getBytes("GBK"),"GBK");
//      pptlInPutStream = new ByteArrayInputStream(s1.getBytes("GBK"));
//        System.out.println(s1);
        pptlInPutStream = new ByteArrayInputStream(s.getBytes());
        InputStream pptlInPutStream1 = readStream(pptlInPutStream,s);  
        return pptlInPutStream1;
        
        ///////////////////////////////////////////////////////////////////////////////////
        //閿熷壙杈炬嫹閿熸枻鎷烽敓渚ヤ紮鎷烽敓鏂ゆ嫹閿熺粸褝鎷烽敓锟� 澶у
//        System.out.println("s閻ㄥ嫬锟斤拷"+s);
//        pptlInPutStream = new ByteArrayInputStream(s.getBytes("utf-8"));
//        return pptlInPutStream;
//        
        
        
        
        /////////////////////////////////////////////////////////////////////////////////////
	}
    

	
    /**
     * 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�
     * 
     * */
	
	/**
     * 閿熸枻鎷锋閿熸枻鎷烽敓鏂ゆ嫹閿熺禉egin閿熸枻鎷峰閿熸枻鎷烽敓鏂ゆ嫹end閿熸枻鎷峰熬
     * @param info 閿熸枻鎷烽敓鏂ゆ嫹鍊兼煇閿熸枻鎷烽敓鏂ゆ嫹閿燂拷
     * @param begin 閿熸枻鎷峰閿熻鍑ゆ嫹
     * @param end 閿熸枻鎷峰熬閿熻鍑ゆ嫹
     * @return 閿熸枻鎷烽敓杈冪櫢鎷烽敓鏂ゆ嫹閿熸枻鎷烽閿熸枻鎷峰嫙閿熸枻鎷烽敓锟�
     */
    public static List<String> getChildMsgByParent(String info,String begin,String end){
        String[] split = info.split(begin);
        List<String> list = new ArrayList<>();
        for (int i = 1; i < split.length; i++) {
            String str = split[i].substring(0,split[i].lastIndexOf(end)+end.length());
            if (str.length()> end.length()) {
                list.add(begin+str);
            }
        }
        return list;
    }

	/**
     * 閿熸枻鎷烽敓鏂ゆ嫹瑕侀敓鏂ゆ嫹鍓嶉敓渚ヨ鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿燂拷  閿熸枻鎷疯閿熸枻鎷烽敓锟� 閿熸枻鎷烽敓鏂ゆ嫹閿熺弹hen閿熸枻鎷烽敓鏂ゆ嫹閿熸帴璇嶅姞浠庢拝鎷�
     * 閿熸枻鎷烽敓鏂ゆ嫹鍘熼敓鍙拝鎷烽敓鏂ゆ嫹閿熸枻鎷峰垹閿熸枻鎷烽敓鏂ゆ嫹鍓嶉敓鏂ゆ嫹閿熻锝忔嫹
     * 鎷奸敓鏂ゆ嫹閿熸枻鎷峰墠閿熸枻鎷烽敓琛楃尨鎷峰墿閿熸磥閮ㄩ敓鏂ゆ嫹
     * @return 閿熸枻鎷烽敓杈冪櫢鎷烽敓鏂ゆ嫹鏈ㄩ敓鏂ゆ嫹閿燂拷
     * getChildMsgByParent(text, "whenever", ".");涓哄啓閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
     */
	
    public static String rearrange(String text)
    {
    	String re_text = "";
    	String match_result="";
    	String pattern ="";
    	int index_string_array = 0;
    	boolean isMatch = false;
    	String[] string_array={"when","whenever"};
    	for(int i=0; i<string_array.length;i++)
    	{
    	pattern = ".*"+string_array[i]+".*";
    	isMatch = Pattern.matches(pattern, text);
    	if(isMatch)
    	{
    		index_string_array = i;
    		i=string_array.length;
    	}
    	}  
    	System.out.println("閿熻鍑ゆ嫹閿熸枻鎷疯棰勯敓鏂ゆ嫹閿熸枻鎷�"+isMatch);
        if(isMatch)
        {
    	List<String> list = getChildMsgByParent(text, string_array[index_string_array], ".");
        for (String s : list) {
            re_text = re_text+s;
        }
        re_text=re_text.replace(".", "");
    	String addition_text = text.replace(re_text, "");
    	re_text = re_text+","+addition_text+".";
    	System.out.println("閿熸枻鎷烽敓鏂ゆ嫹棰勯敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹:"+re_text);
    	return re_text;
        }else
        {
        	return text;
        }
    }
	
	
	
	
		/** 
	   * 閿熸枻鎷峰彇閿熸枻鎷� 
	   *  
	   * @param pptlInPutStream 
	   * @return 閿熻鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹 
		 * @throws IOException 
	   * @throws Exception 
	   */  
	
	
	
	
	  @SuppressWarnings("null")
	private static InputStream readStream(InputStream pptlInPutStream, String stringSentence) throws IOException {
		// TODO 閿熺殕璁规嫹閿熸枻鎷烽敓缂寸殑鍑ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿燂拷
		  BufferedInputStream bufferedInputStream = new BufferedInputStream(pptlInPutStream);
		  byte[] b = new byte[1024*10];
		  int bytesRead = 0;
		  while((bytesRead = bufferedInputStream.read(b)) > -1) {
			  System.out.println(bytesRead);
			  for (int k=0; k<bytesRead;k++ )
			  {
				  System.out.print((char)b[k]);
			  }
		  }
	      pptlInPutStream.close();
		return pptlInPutStream = new ByteArrayInputStream(stringSentence.getBytes());
	}



	
	
	
	
	
	
    public static void main(String[] args) {
    	
    	
    	/** 
		 * 
		 *閿熸枻鎷烽敓钘夊偍閿熻姤鐢婚敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿燂拷 
		 */   
    	
    	Demo frame = new Demo();
        frame.setSize(800, 600);  
        frame.setVisible(true);  
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	
    	
    	
    	
    	
    	
        // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // read some text in the text variable
        //When an anchor vehicle appears in front, the system sets the time in the next state,then the system will send the message,then when the driver presses the switch button, the vehicle switches modes .
        //String text ="When an anchor vehicle appears in front, in the next state the system sets the time which the system change the modes at , then the system will send the message,then the vehicle switches modes when the driver presses the switch button that can switch the modes." ;//Now and then I referred a client to him when gasconcentration exceed 10%,alarm should be activated until  gasconcentration is below 8%;
        String  text= natural_language;
        System.out.println("Demo閿熸枻鎷穞ext閿熸枻鎷峰�间负");
        
        NumUtil NumUtil_object = new NumUtil();
       
        //text = "When an anchor vehicle appears in front, the system sets the time in the next state.";
        //text = NumUtil_object.getNumeric(text);
        //String text ="When an anchor vehicle appears in front, the system sets the time in the next state, then the system will send the message, then when the driver presses the switch button, the vehicle switches modes.";
        //String text ="The point in time is received in a compression master when the leading edge of the first bit of the first symbol after the SOF delimiter." ;
        // create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

        // run all Annotators on this text
        pipeline.annotate(document);
        
        String result="";



        // these are all the sentences in this document
        // a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        
        
        String poss="";
        String s="";     
        String huanyuan="";      
        System.out.println("word\tpos\tlemma\tner");
        for(CoreMap sentence: sentences) {
            for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                // this is the NER label of the token
                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
                poss+=pos+" ";
                huanyuan+=lemma+" ";
                if(!(word.equals(",")||word.equals(";")||word.equals("%")||word.equals(".")||pos.equals("CD")))
                {
                	s+=pos+" "+word+" ";
                }else
                {
                	 s+=" "+word;
                }
            	/** 
            	 * @see 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷疯癄閯勯敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟�
            	 * 
            	 */ 
                System.out.println("word閿熸枻鎷锋伅:"+word);
                
                System.out.println("ne閿熸枻鎷锋伅:"+ne);
                
                System.out.println("pos閿熸枻鎷锋伅:"+pos);
                
                System.out.println("lemma閿熸枻鎷锋伅:"+lemma);
                
                System.out.println(" ");
                
            }
            
            
            
            System.out.println("poss閿熸枻鎷烽敓鏂ゆ嫹鎭�:"+poss);
            System.out.println("s閿熸枻鎷烽敓鏂ゆ嫹鎭�:"+s);
            System.out.println("huanyuan閿熸枻鎷烽敓鏂ゆ嫹鎭�:"+huanyuan);
            
            
        	/** 
        	 * ******************************************************************************
        	 * 閿熸嵎鐧告嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹璇橀敓鏂ゆ嫹閿熻緝顫嫹閿熸枻鎷烽敓绲媟eePanel閿熸枻鎷穎rame閿熸枻鎷烽敓鏂ゆ嫹TreePanel閿熸枻鎷风ず閿熸枻鎷烽敓鏂ゆ嫹
        	 */ 

            Tree tree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
            traverse_tree(tree,tree);
            TreePanel drawtree = new TreePanel(tree,store_node_depth,store_node_weigh,store_node_label);
            frame.add(drawtree);
            frame.setVisible(true);
        
           
            System.out.println(String.format("tree:\n%s",tree.toString()));
            Tree[] treeChildren =tree.children(); 
            System.out.println("閿熸枻鎷烽敓渚ョ鎷蜂竴閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓瑙掔殑璁规嫹閿熻淇濊揪鎷烽敓鏂ゆ嫹treeChildree"+treeChildren[0].toString());
            System.out.println(String.format("閿熸枻鎷蜂竴閿熸枻鎷烽敓鏂ゆ嫹閿熸帴鐨勭鎷蜂竴閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷穞reechildnodeString:\n%s",treeChildren[0].children()[0].label()));
            System.out.println("閿熸枻鎷烽敓鏂ゆ嫹寰敓鏂ゆ嫹");
            
           
            // this is the Stanford dependency graph of the current sentence
            SemanticGraph dependencies = sentence.get(SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation.class);
          
//            System.out.println(String.format("dependencies:\n%s",dependencies.toString()));
//            System.out.println(String.format("typedDependencies:\n%s",dependencies.typedDependencies().toString()));
        }

// This is the coreference link graph
// Each chain stores a set of mentions that link to each other,
// along with a method for getting the most representative mention
// Both sentence and token offsets start at 1!
        Map<Integer, CorefChain> graph =
                document.get(CorefCoreAnnotations.CorefChainAnnotation.class);
    }
    
 
    
    
    
    
    
    
    
    
 public static String regex="[-0-9].*";
    
    public static void traverse_tree(Tree tree,Tree node)
    {
        if(node.children()!= null)
        {
        for(int i=0;i<node.children().length;i++) 
           {
        	//System.out.printf("閿熸枻鎷烽敓渚ョ鎷�%d閿熸枻鎷�",tree.depth(node)+1);    
        	//System.out.printf("閿熶茎纰夋嫹%d閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷�,",i+1);
        	node_depth=(tree.depth(node)+1)*50;
            //node_weigh=node_weigh+10;
        	 if (pre_node_depth > node_depth)
             {
             	node_weigh=node_weigh+30;
             }
            //System.out.println("閿熸枻鎷烽敓锟�:"+node_weigh+"閿熸枻鎷烽敓锟�:"+node_depth+"閿熻妭纰夋嫹閿熸枻鎷烽敓杈冿拷:"+node.getChild(i).label().toString().replaceAll(regex, ""));
            store_node_depth[count]=node_depth;
            store_node_weigh[count]=node_weigh;
            store_node_label[count]=node.getChild(i).label().toString().replaceAll(regex, "");
            count++;
            if(node.getChild(i).children()!=null)
            {
            	pre_node_depth = node_depth;
            	traverse_tree(tree,node.getChild(i));
            }
    	}
        }
    }
    
}

