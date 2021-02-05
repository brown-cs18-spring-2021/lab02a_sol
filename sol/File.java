package sol;

import java.util.LinkedList;
import java.util.List;

import src.Item;

public class File {
  public List<Item> file;

  public File(List<Item> file) {
    this.file = file;
  }

  void addItem(Item item) {
    file.add(item);
  }

  void removeItem(Item item) {
    file.remove(item);
  }

  /**
   * Looks up if an item has been solved or not.
   * 
   * @param d - the description to match
   * @return the boolean indicating if the File has been solved or not
   * @throws RuntimeException when the item does not exist in the list
   */
  boolean lookupSolved(String d) throws RuntimeException {
    for (Item i : file) {
      if (i.description.equals(d))
        return i.solved;
    }
    throw new RuntimeException("item not found");

  }

  /**
   * Counts the number of items in the catalog whose descriptions contain a
   * given substring.
   * 
   * @param d - the substring to look for.
   * @return the number of items whose description contains d.
   */
  int countCases(String d) {
    int c = 0;

    for (Item i : file) {
      if (i.description.contains(d))
        c++;
    }

    return c;
  }

  /**
   * Returns a list of the items in the catalog whose descriptions contain a
   * given substring.
   * 
   * @param d - the substring to look for.
   * @return a list of all the items whose description contains d.
   */
  List<Item> findCases(String d) {
    List<Item> list = new LinkedList<Item>();

    for (Item i : file) {
      if (i.description.contains(d))
        list.add(i);
    }

    return list;
  }

  /**
   * Changes the solved field for all items with description d.
   *
   * @param d - the description to look for.

   * @return the number of items whose description is equal to d.
   */
  void updateSolved(String d, boolean newSolved) {
    for (Item i : file) {
      if (d.equals(i.description))
        i.solved = newSolved;

    }

  }
}
