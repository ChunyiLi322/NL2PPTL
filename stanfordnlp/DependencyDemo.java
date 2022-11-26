/**
 * PS C:\Users\lichunyi> dot -v
dot - graphviz version 2.49.0 (20210828.1703)
libdir = "C:\Program Files\Graphviz\bin"
Activated plugin library: gvplugin_dot_layout.dll
Using layout: dot:dot_layout
Activated plugin library: gvplugin_core.dll
Using render: dot:core
Using device: dot:dot:core
The plugin configuration file:
        C:\Program Files\Graphviz\bin\config6
                was successfully loaded.
    render      :  cairo dot dot_json fig gdiplus json json0 map mp pic pov ps svg tk vml xdot xdot_json
    layout      :  circo dot fdp neato nop nop1 nop2 osage patchwork sfdp twopi
    textlayout  :  textlayout
    device      :  bmp canon cmap cmapx cmapx_np dot dot_json emf emfplus eps fig gif gv imap imap_np ismap jpe jpeg jpg json json0 metafile mp pdf pic plain plain-ext png pov ps ps2 svg tif tiff tk vml xdot xdot1.2 xdot1.4 xdot_json
    loadimage   :  (lib) bmp eps gif jpe jpeg jpg png ps svg
 */
package stanfordnlp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.JFrame;

import DrawTree.TreePanel;
import GraphViz.DrawDependencyTree;
import edu.stanford.nlp.coref.CorefCoreAnnotations;
import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.PennTreebankLanguagePack;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.trees.TreeCoreAnnotations.TreeAnnotation;
import edu.stanford.nlp.trees.TreebankLanguagePack;
import edu.stanford.nlp.trees.TypedDependency;
import edu.stanford.nlp.util.CoreMap;
import mainPro.NumUtil;

public class DependencyDemo {

	public static String DependencyDemo_natural_language ="If manual_mode is running and start_auto_control_button is pressed, next auto_control_mode is running.";
	public static ArrayList relation = new ArrayList<>();
	public static ArrayList words = new ArrayList<>();
	public static ArrayList heads = new ArrayList<>();
	
	   public DependencyDemo(String natural_language) {
		// TODO Auto-generated constructor stub
		   DependencyDemo_natural_language = natural_language;
	}

	public static void main(String[] args) {
	    	
	    	
	    	/** 
			 * 
			 *¶¨Òå´¢´æÒÀ´æ»­°åµÄÈÝÆ÷ 
			 */   
	    	
	    	Demo frame = new Demo();
	        frame.setSize(1200, 500);  
	        frame.setVisible(true);  
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        Properties props = new Properties();
	        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
	        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
	        String  text= DependencyDemo_natural_language;	        
	        NumUtil NumUtil_object = new NumUtil();       
	        Annotation document = new Annotation(text);
	        pipeline.annotate(document);
	        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
	        
	        for (CoreMap sentence: sentences) {       
	            Tree tree = sentence.get(TreeAnnotation.class);    
	            TreebankLanguagePack tlp = new PennTreebankLanguagePack(); 

	            GrammaticalStructureFactory gsf = tlp.grammaticalStructureFactory(); 
	            GrammaticalStructure gs = gsf.newGrammaticalStructure(tree); 

	            Collection<TypedDependency> tdl = gs.typedDependenciesCCprocessed(); 
	            tdl.stream().forEach(typedDependency -> {
	            	System.out.println("Governor Word: [" + typedDependency.gov() + "] Relation: [" + typedDependency.reln().getLongName() + "] Dependent Word: [" + typedDependency.dep() + "]");
	                relation.add(typedDependency.reln().getLongName());
	                //words.add(typedDependency.gov().lemma()+"-"+typedDependency.gov().hashCode());
	                //heads.add(typedDependency.dep().lemma()+"-"+typedDependency.dep().hashCode());
	                words.add(typedDependency.gov().lemma()+"");
	                heads.add(typedDependency.dep().lemma()+"");
	            });

	            System.out.println(tdl); 
	            for(int i = 0 ; i<relation.size();i++){
	    			System.out.println(relation.get(i)+"("+words.get(i)+","+heads.get(i)+")");
	    			}

	          } 
	        DrawDependencyTree drawDependencyTree = new DrawDependencyTree(relation,words,heads);    
            frame.add(drawDependencyTree);
            frame.setVisible(true);
	    	

	    
	  }
}
