package jian.com.utils.des3;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class MyTest {
    @Test
    public void getDatasByClass() {
        Rule rule = new Rule("http://www1.sxcredit.gov.cn/public/infocomquery.do?method=publicIndexQuery", new String[] { "query.enterprisename",
                "query.registationnumber" }, new String[] { "兴网", "" }, "cont_right", Rule.CLASS, Rule.POST);
        List<LinkTypeData> extracts = ExtractService.extract(rule);
        printf(extracts);
    }

    @Test
    public void getDatasByCssQuery() {
        Rule rule = new Rule("http://www.11315.com/search", new String[] { "name" }, new String[] { "哈哈" }, "div.g-mn div.con-model", Rule.SELECTION, Rule.GET);
        List<LinkTypeData> extracts = ExtractService.extract(rule);
        printf(extracts);
    }

    public void printf(List<LinkTypeData> datas) {
        for (LinkTypeData data : datas) {
            System.out.println(data.getLinkText());
            System.out.println(data.getLinkHref());
            System.out.println("***********************************");
        }

    }

    /**
     * 使用百度新闻，只设置url和关键字与返回类型
     */
    @Test
    public void getDatasByCssQueryUserBaidu() {
        Rule rule = new Rule("http://news.baidu.com/ns", new String[] { "word" }, new String[] { "中央政治局召开" }, null, -1, Rule.GET);
        List<LinkTypeData> extracts = ExtractService.extract(rule);
        printf(extracts);
    }

    @Test
    public void getLianjiaInfo() {
        Rule rule = new Rule("http://search.sina.com.cn/?c=news", new String[] { "q" }, new String[] { "汤唯" }, null, -1, Rule.GET);
        List<LinkTypeData> extracts = ExtractService.extract(rule);
        printf(extracts);
    }

    @Test
    public void getHtml() throws Exception {
        Document document = Jsoup.connect("http://www.11315.com/newSearch").get();
        Elements content = document.getElementsByClass("search_box");
        Elements datas = content.get(0).getElementsByClass("search_box");
        for (Element element : datas) {
            Elements byTag = element.getElementsByTag("li");
            for (int j = 0; j < byTag.size(); j++) {
                if (!"".equals(byTag.get(j).text())) {
                    System.out.println(byTag.get(j).text());
                }
            }
        }
    }
}
