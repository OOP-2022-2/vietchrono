package hust.soict.oop.scraper.figure;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NKSDataCollector  extends FigureDataCollector{
    public NKSDataCollector() {
    }

    @Override
    public List<String> getAllUrls(String url) throws IOException {
        
        List<String> allLinks = new ArrayList<String>();

        for (int i = 0; i < 291; i++) {
            Document doc = getDoc(url + "?start=" + i * 5);
            
            Elements eLinkCharater = doc.select("h2");
            
            for (Element r : eLinkCharater) {
                String link = r.select("a").attr("href");
                allLinks.add("https://nguoikesu.com" + link);
            }
        }

        return allLinks;
    }

    @Override
    public void getData(List<String> allUrls) throws IOException {
        

        Writer writer = new FileWriter("src/main/java/hust/soict/oop/scraper/figure/data/nks.json");
            writer.write("[\n");
        int count = 0;
        for (String url : allUrls) {
            
            String name = null;
            String description = "";
            String sinh = null;
            String mat = null;
            String time = "không rõ";
            String otherName = "không rõ";
            String place = "không rõ";
            String period = "không rõ";
            
            Figure figure = new Figure();

            Document doc = getDoc(url);

            name = doc.select("div.page-header h2").text();
            figure.setName(name);

            Elements infobox = doc.select("table.infobox");
            Elements articleBody = doc.select("div[class = com-content-article__body]");
            Elements paragraphs = articleBody.select("p");

            if (infobox.size() > 0) {
                Elements rows = infobox.get(0).select("tr");
             
                for (Element r : rows) {
                    Elements eKey = r.select("th");
                    Elements eValue = r.select("td");
                    if (eKey.size() > 0 && eValue.size() > 0) {
                        String key = eKey.text();
                        String value = eValue.text();

                        if (key.equals("Sinh")) {
                            sinh = eValue.text();
                        }
                        if (key.equals("Mất")) {
                            mat = eValue.text();
                        }

                            description += key + ": " + value + "\n";
                    }        
                    if (eValue.size() == 0) {
                        String value = r.text();
                        description += value + "\n";
                    }
                }
                time = (sinh == null ? "Không rõ" : sinh) + " - " + (mat == null ? "Không rõ" : mat);
                figure.setTime(time);
           
                if (paragraphs.size() > 0) {
                    for (Element p : paragraphs) {
                        if (!p.text().equals("")) {
                            description += p.text() + "\n";
                        }
                    }
                }
                figure.setDescription(description);
                figure.setOtherName(otherName);
                figure.setPlace(place);
                figure.setPeriod(period);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(figure, writer);
                writer.flush();
                writer.write(",\n");
                count++;
            }
            else {
            	if (paragraphs.size() > 0) {
            		String info = paragraphs.get(0).text();
					String timeRegex ="("+name+" )"+"(\\()([^)]*)(\\))";
					Pattern p = Pattern.compile(timeRegex);
				    Matcher matcher = p.matcher(info);
				    boolean matchFound = matcher.find();
				    if(matchFound) {
					      String nameTime = matcher.group();
					      String Regex = "\\(.*\\)";
					      Pattern pattern = Pattern.compile(Regex);
					      Matcher m = pattern.matcher(nameTime);
					      boolean match = m.find();
					      String time1 = "Không rõ";
					      if(match){
					      	String str = m.group();
					      	time1 = str.substring(1, str.length()-1);
					      }
					      figure.setName(name);
					      figure.setTime(time1);
					      Elements pTags1 = articleBody.select("#toc ~ *");
					      if(pTags1.size()>0) {
							for(Element p1 : pTags1) {								
								if(!p1.text().equals("")) description+=p1.text()+"\n";
							}
					      }
					      else {
					    	  description = "";
					      }
					      figure.setDescription(description);
					      figure.setOtherName(otherName);
						  figure.setPlace(place);
						  figure.setPeriod(period);
						  count++;
						  Gson gson = new GsonBuilder().setPrettyPrinting().create();
						  gson.toJson(figure, writer);
						  writer.write(",\n");
					      
					}
				    else {
					    	figure.setName(name);
					    	figure.setTime("Không rõ");
					    	Elements pTags1 = articleBody.select("#toc ~ *");
						    if(pTags1.size()>0) {
								for(Element p1 : pTags1) {
									if(!p1.text().equals("")) description+=p1.text()+"\n";
								}
						    }
						    else {
						    	  description = "";
						    }
						    figure.setDescription(description);
						    figure.setOtherName(otherName);
						    figure.setPeriod(period);
							figure.setPlace(place);

							count++;
						    Gson gson = new GsonBuilder().setPrettyPrinting().create();
						    gson.toJson(figure, writer);
						    writer.write(",\n");							
					}
					
				
            	}
            	
            }

        }

        System.out.println(count);    
        writer.write("\n]");
        writer.close();
        System.out.println("Done");
    }

    @Override
    public void Start() throws IOException {
        String url = "https://nguoikesu.com/nhan-vat";
        List<String> allLinks= getAllUrls(url);
        

        NKSDataCollector nks = new NKSDataCollector();
        nks.getData(allLinks);

    }
    

//     public static void main(String[] args) throws IOException {
//         NKSDataCollector nks = new NKSDataCollector();
//    	 nks.Start();
//     }
    // 1450 nv
    
}
