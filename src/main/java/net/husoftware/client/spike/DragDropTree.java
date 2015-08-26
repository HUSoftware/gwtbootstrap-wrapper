package net.husoftware.client.spike;

/* This file is part of "DragDropTree".

 "DragDropTree" is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 "DragDropTree" is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with "DragDropTree".  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class DragDropTree implements EntryPoint
{
  @Override
  public void onModuleLoad()
  {
    Tree tree = new Tree();

    RootPanel.get("main").add(tree);

    // root is not draggable.
    TreeItem treeItem = new TreeItem(new DragDropLabel("root", false, true));
    tree.addItem(treeItem);

    // Add some folders
    treeItem.addItem(new DragDropLabel("folder1", true, true));
    treeItem.addItem(new DragDropLabel("folder2", true, true));

    TreeItem folder3 = treeItem.addItem(new DragDropLabel("folder3", true, true));
    folder3.addItem(new DragDropLabel("folder3-1", true, true));
    folder3.addItem(new DragDropLabel("folder3-2", true, true));

    // Add some leaves to the tree
    List<TreeItem> stack = new ArrayList<TreeItem>();
    stack.add(tree.getItem(0));

    int filenum = 1;
    while (!stack.isEmpty())
    {
      TreeItem item = stack.remove(0);
      for (int i = 0; i < item.getChildCount(); i++)
      {
        stack.add(item.getChild(i));
      }

      int files = Random.nextInt(4) + 1;
      for (int j = 0; j < files; j++)
      {
        item.addItem(new TreeItem(new DragDropLabel("File " + filenum, true, false)));
        filenum++;
      }
      item.setState(true);
    }
  }
}
