package sol;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import src.Item;
import tester.Tester;

public class FileTest {
  public static File makeStandardHelper() {
    Item a = new Item("sock", true);
    Item b = new Item("sock", true);
    Item c = new Item("sock with hole", false);
    Item d = new Item("computer", true);
    Item e = new Item("CIT", false);

    List<Item> file = Arrays.asList(new Item[] {a, b, c, d, e});
    return new File(file);
  }

  public static File makeModifiedHelper() {
	    Item a = new Item("sock", false);
	    Item b = new Item("sock", false);
        Item c = new Item("sock with hole", false);
	    Item d = new Item("computer", true);
	    Item e = new Item("CIT", false);

	    List<Item> file = Arrays.asList(new Item[] {a, b, c, d, e});
	    return new File(file);
	  }

  public static void testLookup(Tester t) {
    File helper = makeStandardHelper();
    t.checkExpect(helper.lookupSolved("sock"), true);

    File emptyHelper = new File(new LinkedList<Item>());
    t.checkException(new RuntimeException("item not found"), emptyHelper, "lookupSolved", "sock");
  }

  public static void testCount(Tester t) {
    File helper = makeStandardHelper();
    t.checkExpect(helper.countCases("sock"), 3);

    File emptyHelper = new File(new LinkedList<Item>());
    t.checkExpect(emptyHelper.countCases("sock"), 0);
  }

  public static void testfindCases(Tester t) {
    File helper = makeStandardHelper();
    Item a = new Item("sock", true);
    Item b = new Item("sock", true);
    Item c = new Item("sock with hole", false);

    List<Item> ans2 = new LinkedList<Item>();
    ans2.add(a);
    ans2.add(b);
    ans2.add(c);
    t.checkExpect(helper.findCases("sock"), ans2);
    
    File emptyHelper = new File(new LinkedList<Item>());
    t.checkExpect(emptyHelper.findCases("sock"), new LinkedList<Item>());
  }

  public static void testUpdate(Tester t) {
    File helper = makeStandardHelper();
    File sol = makeModifiedHelper();
    helper.updateSolved("sock", false);
    t.checkExpect(helper.file, sol.file);

    File helper2 = makeStandardHelper();
    helper2.updateSolved("sock", false);


    helper.updateSolved("sock222", true);
    t.checkExpect(helper.file, helper2.file);
  }

  public static void main(String[] args) {
    Tester.run(new FileTest());
  }
}
