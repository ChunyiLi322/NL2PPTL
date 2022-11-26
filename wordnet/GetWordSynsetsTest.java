package wordnet;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.ISynset;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;
import javax.swing.JOptionPane;


public class GetWordSynsetsTest {
	public static void main(String[] args) throws IOException{
		String Path="C:\\Program Files (x86)\\WordNet\\2.1\\dict";
		File wnDir=new File(Path);
		URL url=new URL("file", null, Path);
		IDictionary dict=new Dictionary(url);
		dict.open();//�򿪴ʵ�
		getSynonyms(dict); //testing
	}
	
	public static ArrayList<String> GetWordSynsets(String words) throws IOException{
		String Path="C:\\Program Files (x86)\\WordNet\\2.1\\dict";
		File wnDir=new File(Path);
		URL url=new URL("file", null, Path);
		IDictionary dict=new Dictionary(url);
		dict.open();//�򿪴ʵ�
		return getSynonyms(words,dict); //testing
	}


	public static void getSynonyms(IDictionary dict){
			// look up first sense of the word "go"
			//IIndexWord idxWord2 = dict.
		IIndexWord idxWord =dict.getIndexWord("all_the_time", POS.ADJECTIVE);
		IWordID wordID = idxWord.getWordIDs().get(0) ; // 1st meaning
		IWord word = dict.getWord(wordID);
		ISynset synset = word.getSynset (); //ISynset��һ���ʵ�ͬ��ʼ��Ľӿ�


// iterate over words associated with the synset
		for(IWord w : synset.getWords())
			System.out.println(w.getLemma());//��ӡͬ��ʼ��е�ÿ��ͬ���
	}
	
	public static ArrayList<String> getSynonyms(String words,IDictionary dict){
		// look up first sense of the word "go"
		//IIndexWord idxWord2 = dict.
		IIndexWord idxWord =dict.getIndexWord(words, POS.ADVERB);
		IWordID wordID = idxWord.getWordIDs().get(0) ; // 1st meaning
		IWord word = dict.getWord(wordID);
		ISynset synset = word.getSynset (); //ISynset��һ���ʵ�ͬ��ʼ��Ľӿ�

		ArrayList<String> synWords=new ArrayList<String>();
		//iterate over words associated with the synset
		for(IWord w : synset.getWords())
		{
			synWords.add(w.getLemma());
			System.out.println(w.getLemma());//��ӡͬ��ʼ��е�ÿ��ͬ���
		}
		return  synWords;
			
	}
}
