package net.husoftware.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.husoftware.client.model.ButtonGroupDisplay;
import net.husoftware.client.model.CallBack;
import net.husoftware.client.model.ContainerDisplay;
import net.husoftware.client.model.HasPosition;
import net.husoftware.client.model.HeaderBarDisplay;
import net.husoftware.client.model.ListGroupDisplay;
import net.husoftware.client.model.ModalDisplay;
import net.husoftware.client.model.NavTabDisplay;
import net.husoftware.client.model.TableDisplay;
import net.husoftware.client.spike.DragDropLabel;
import net.husoftware.client.ui.ButtonGroupView;
import net.husoftware.client.ui.ButtonView;
import net.husoftware.client.ui.ContainerView;
import net.husoftware.client.ui.ContenteditableView;
import net.husoftware.client.ui.DateSelectView;
import net.husoftware.client.ui.DateTimePickerView;
import net.husoftware.client.ui.DndController;
import net.husoftware.client.ui.HeaderBarView;
import net.husoftware.client.ui.IconView;
import net.husoftware.client.ui.ListGroupView;
import net.husoftware.client.ui.ModalView;
import net.husoftware.client.ui.NavTabView;
import net.husoftware.client.ui.SelectView;
import net.husoftware.client.ui.SuggestBoxView;
import net.husoftware.client.ui.TableSortView;
import net.husoftware.client.ui.TableView;
import net.husoftware.client.ui.TextAreaView;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Label;
import org.gwtbootstrap3.client.ui.ListGroupItem;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.SuggestBox;
import org.gwtbootstrap3.client.ui.TextArea;
import org.gwtbootstrap3.client.ui.constants.ButtonSize;
import org.gwtbootstrap3.client.ui.constants.ButtonType;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.gwt.FlowPanel;
import org.gwtbootstrap3.extras.animate.client.ui.constants.Animation;
import org.gwtbootstrap3.extras.datetimepicker.client.ui.DateTimePicker;
import org.gwtbootstrap3.extras.growl.client.ui.Growl;
import org.gwtbootstrap3.extras.typeahead.client.base.StringDataset;
import org.gwtbootstrap3.extras.typeahead.client.ui.Typeahead;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ToggleButton;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.datepicker.client.DateBox;

public class Showcase implements EntryPoint
{
  @Override
  public void onModuleLoad()
  {
    RootPanel root = RootPanel.get();

    addButtonGroupView(root);

    addTableView(root);

    addTableSortView(root);

    addListGroupViewWithSortAbility(root);

    addDndControllerWithListGroupView(root);

    addDndControllerWithFlexTable(root);

    dndTree(root);

    textAreaFunctions(root);

    elasticTextArea(root);

    contentEditableView(root);

    anitimateIcon(root);

    dateBox(root);

    selectView(root);

    typeAHeadStatic(root);

    suggestBoxView(root);

    suggestBox(root);

    headerBar(root);

    containerDisplay(root);

    modalPop(root);

    modalViewPop(root);

    dangerButton(root);

    datePickerView(root);

    dateSelectView(root);
  }

  private void addButtonGroupView(RootPanel inRoot)
  {
    inRoot.add(new HTMLPanel("<hr />Button Group View"));
    HorizontalPanel panel = new HorizontalPanel();
    inRoot.add(panel);

    final ButtonGroupView btn1 = new ButtonGroupView();
    panel.add(btn1);
    btn1.setText("Group1");
    btn1.setSplit(true);
    btn1.setProperty("btn1");
    btn1.setTip(null);

    final ButtonGroupDisplay btn2 = new ButtonGroupView();
    panel.add(btn2);
    btn2.setText("Group2");
    btn2.setSplit(false);
    btn2.setProperty("btn2");
    btn2.setTip("hello");

    final ButtonGroupDisplay btn3 = new ButtonGroupView();
    panel.add(btn3);
    btn3.setText("Group3");
    btn3.setDataToggle(null);
    btn3.setProperty("btn3");

    final ButtonGroupDisplay btn4 = new ButtonGroupView();
    panel.add(btn4);
    btn4.setText("Group4");
    btn4.setProperty("btn4");

    ClickHandler hander = new ClickHandler()
    {
      private boolean noDrop;

      @Override
      public void onClick(ClickEvent inEvent)
      {
        Growl.growl("results1: " + btn1.getProperty(inEvent));

        // Growl.growl("results1: " + btn1.isItemProperty(inEvent, "Hello"));
        // Growl.growl("results1b: " + btn1.isProperty("btn1"));
        // Growl.growl("results1c: " + btn1.isProperty(inEvent, "btn1"));
        // Growl.growl("results2: " + btn2.isItemProperty(inEvent, "World"));
        // Growl.growl("results3: " + btn3.isSource(inEvent));
        // Growl.growl("results4: " + btn4.isSource(inEvent));
        // Growl.growl("results4b: " + btn4.isItemProperty(inEvent, "btn4"));

        if (btn4.isItemProperty(inEvent, "item4"))
        {
          noDrop = !noDrop;
          btn4.setNoDrop(noDrop);
        }
        else if (btn4.isNoDrop() && btn4.isSource(inEvent))
        {
          noDrop = !noDrop;
          btn4.setNoDrop(noDrop);
        }
      }
    };
    btn1.setClickHandler(hander);
    btn2.setClickHandler(hander);
    btn3.setClickHandler(hander);
    btn4.setClickHandler(hander);
    btn1.addItem("This is my item (1)", "tip1", "item1", hander);
    btn2.addItem("This is my item (2)", "tip2", "item2", hander);
    btn3.addItem("This is my item (3)", "tip3", "item3", hander);
    btn4.addItem("This is my item (4)", "tip4", "item4", hander);
    btn4.addDivider();
    btn4.addItem("This is my item (4b)", "tip4b", "item4b", hander);
  }

  private void addTableSortView(RootPanel inRoot)
  {
    inRoot.add(new HTMLPanel("<hr />Table Sort View"));
    TableSortView table = new TableSortView();
    inRoot.add(table);

    FlowPanel item0 = new FlowPanel();
    item0.add(new InlineLabel("Hello World 00"));
    table.add(item0);

    FlowPanel item1 = new FlowPanel();
    item1.add(new InlineLabel("Hello World 01"));
    table.add(item1);

    FlowPanel item2 = new FlowPanel();
    item2.add(new InlineLabel("Hello World 02"));
    table.add(item2);

    table.makeSortable();
  }

  private void dateSelectView(RootPanel inRoot)
  {
    inRoot.add(new HTMLPanel("<hr />date select"));

    final DateSelectView dates = new DateSelectView();
    inRoot.add(dates);
    ButtonView showdates = new ButtonView("Show dates");
    showdates.addClickHandler(new ClickHandler()
    {
      @Override
      public void onClick(ClickEvent inEvent)
      {
        System.out.println(dates.getValue());
      }
    });
    inRoot.add(showdates);
    ButtonView setdate = new ButtonView("Set dates");
    setdate.addClickHandler(new ClickHandler()
    {
      @Override
      public void onClick(ClickEvent inEvent)
      {
        dates.setValue(new Date(1L));
      }
    });
    inRoot.add(setdate);
  }

  private void datePickerView(RootPanel inRoot)
  {
    inRoot.add(new HTMLPanel("<hr />date time picker"));

    DateTimePickerView date = new DateTimePickerView();
    date.setWidth("100px");
    inRoot.add(date);
  }

  private void dangerButton(RootPanel inRoot)
  {
    inRoot.add(new HTMLPanel("<hr />button view danger"));

    ButtonView button = new ButtonView();
    button.setType(ButtonType.DANGER);
    button.setSize(ButtonSize.DEFAULT);
    button.setText("Danger");
    inRoot.add(button);
  }

  private void modalViewPop(RootPanel root)
  {
    root.add(new HTMLPanel("<hr />modal view pop"));

    Button modalviewpop = new Button("Open Pop", new ClickHandler()
    {
      @Override
      public void onClick(ClickEvent inEvent)
      {
        ModalDisplay dialog = new ModalView();
        dialog.setWidth("600px");
        dialog.setHeight("300px");
        NavTabDisplay t1 = new NavTabView();
        dialog.addBody(t1);
        dialog.getHeader().setText("insulin glargine 10 units once daily");
        dialog.setCloseVisible(true);

        t1.setStyle("col-md-12");
        t1.getTab1().set("Medication", new Label("Hello1"));
        t1.getTab2().set("Obtained", new Label("Hello2"));
        t1.getTab3().set("Pss", new Label("Hello3"));
        t1.getTab4().set("Drug", new Label("Hello4"));
        t1.getTab5().set("Other", new Label("Hello5"));

        dialog.setShow(true);
      }
    });
    root.add(modalviewpop);
  }

  private void modalPop(RootPanel inRoot)
  {
    inRoot.add(new HTMLPanel("<hr />button show modal"));

    Button modalpop = new Button("Open Pop", new ClickHandler()
    {
      @Override
      public void onClick(ClickEvent inEvent)
      {
        Modal dialog = new Modal();
        dialog.setWidth("600px");
        dialog.setHeight("300px");
        NavTabDisplay t1 = new NavTabView();
        dialog.add(t1);
        dialog.setTitle("insulin glargine 10 units once daily");

        t1.setStyle("col-md-12");
        t1.getTab1().set("Medication", new Label("Hello1"));
        t1.getTab2().set("Obtained", new Label("Hello2"));
        t1.getTab3().set("Pss", new Label("Hello3"));
        t1.getTab4().set("Drug", new Label("Hello4"));
        t1.getTab5().set("Other", new Label("Hello5"));

        dialog.show();
      }
    });
    inRoot.add(modalpop);
  }

  private void containerDisplay(RootPanel inRoot)
  {
    inRoot.add(new HTMLPanel("<hr />ContainerView with TableView"));

    ContainerDisplay container = new ContainerView();
    container.getHead().add(new Label("Medications"));
    container.getFoot().setVisible(false);
    // container.getFoot().add(new Label("Medications"));
    NavTabDisplay tab1 = container.addNavTab();
    NavTabDisplay tab2 = container.addNavTab();

    final TableDisplay table = new TableView();
    table.addColHead("Current Medications");
    table.addColHead("May 2, 2012", "pull-right");

    final Label row1 = new Label("hello row 1");
    table.setWidget(0, 0, row1);
    table.setColSpan(0, 0, 2);

    table.setWidget(1, 0, new Label("hello row 2"));
    table.setColSpan(1, 0, 2);

    table.setWidget(2, 0, new Label("hello row 3"));
    table.setColSpan(2, 0, 2);

    table.setWidget(3, 0, new Label("hello row 4"));
    table.setColSpan(3, 0, 2);

    table.setWidget(4, 0, new Label("hello row 5"));
    table.setColSpan(4, 0, 2);

    InlineLabel glif = new InlineLabel();
    glif.setStyleName("glyphicon glyphicon-eye-open text-primary");
    table.setWidget(2, 0, glif);
    table.setColSpan(2, 0, 2);

    tab1.getTab1().set("Vumc List", table);
    tab1.getTab2().set("Non-Vumc List", new Label("tab2"));

    tab2.getTab1().set("Today's Medication List Scratchpad", new Label("tab1"));

    tab2.getLeft().add(new ButtonView("Add", ButtonType.PRIMARY));
    tab2.getLeft().add(new ButtonView("Add NKM", ButtonType.PRIMARY));
    tab2.getLeft().add(new ButtonView("Reject", ButtonType.WARNING));
    tab2.getRight().add(new ButtonView("Complete", ButtonType.SUCCESS));
    tab2.getRight().add(new ButtonView("Approve", ButtonType.DANGER));

    inRoot.add(container);
  }

  private void headerBar(RootPanel inRoot)
  {
    inRoot.add(new HTMLPanel("<hr />header bar"));

    HeaderBarDisplay navbar = new HeaderBarView();
    navbar.getText().setText("Ztestfourni, Brad Eli 030130884");
    navbar.getText1().setText("11/01/2009");
    navbar.getText2().setText("3yo");
    navbar.getText3().setText("M");
    inRoot.add(navbar);
  }

  private void suggestBox(RootPanel inRoot)
  {
    inRoot.add(new HTMLPanel("<hr />suggest box"));

    MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
    oracle.add("John");
    oracle.add("Jones");
    oracle.add("Java");
    oracle.add("Jackson");
    SuggestBox suggest = new SuggestBox(oracle);
    inRoot.add(suggest);
  }

  private void suggestBoxView(RootPanel inRoot)
  {
    inRoot.add(new HTMLPanel("<hr />suggest view box"));

    SuggestBoxView suggestview = new SuggestBoxView();
    inRoot.add(suggestview);
  }

  private void typeAHeadStatic(RootPanel inRoot)
  {
    final List<String> persons = getPersons();

    List<String> names = new ArrayList<String>();
    for (String person : persons)
    {
      names.add(person);
    }

    StringDataset dataset = new StringDataset(names);
    Typeahead<String> typeaheadstatic = new Typeahead<String>(dataset);
    typeaheadstatic.setPlaceholder("Enter a name");

    inRoot.add(typeaheadstatic);
  }

  private List<String> getPersons()
  {
    final List<String> persons = new ArrayList<String>();
    persons.add(newPerson("Bill", 50));
    persons.add(newPerson("Bob", 38));
    persons.add(newPerson("Bobak", 24));
    persons.add(newPerson("Dawton", 27));
    persons.add(newPerson("Dinkelstein", 66));
    persons.add(newPerson("Eumon", 13));
    persons.add(newPerson("Gene", 42));
    persons.add(newPerson("Gus", 31));
    persons.add(newPerson("Jebediah", 57));
    persons.add(newPerson("Kirrim", 73));
    persons.add(newPerson("Linus", 103));
    persons.add(newPerson("Mortimer", 7));
    persons.add(newPerson("Walt", 15));
    persons.add(newPerson("Wernher", 52));
    return persons;
  }

  private void selectView(RootPanel inRoot)
  {
    inRoot.add(new HTMLPanel("<hr />select view"));

    SelectView select = new SelectView();
    inRoot.add(select);
  }

  private void datePicker(RootPanel inRoot)
  {
    inRoot.add(new HTMLPanel("<hr />date picker"));

    DateTimePicker picker = new DateTimePicker();
    inRoot.add(picker);

    picker.show();
  }

  private void dateBox(RootPanel root)
  {
    root.add(new HTMLPanel("<hr />date box"));

    DateBox date = new DateBox();
    root.add(date);
  }

  private void anitimateIcon(RootPanel root)
  {
    root.add(new HTMLPanel("<hr />icon view"));

    IconView icon = new IconView(IconType.GOOGLE_PLUS, "Hello");
    root.add(icon);
    icon.animate(Animation.BOUNCE, 1, -1, -1);
  }

  private void contentEditableView(RootPanel root)
  {
    root.add(new HTMLPanel("<hr />content editable"));
    root.add(new ContenteditableView());
    TextArea w = new TextArea();
    w.setWidth("40px");
    root.add(w);
  }

  private void elasticTextArea(RootPanel root)
  {
    root.add(new HTMLPanel("<hr />elastic textarea"));
    TextAreaView elastic = new TextAreaView();
    // elastic.elastic();
    elastic.setWidth("100px");
    root.add(elastic);
  }

  private void textAreaFunctions(RootPanel inRoot)
  {
    final TextArea textArea = new TextArea();
    inRoot.add(new HTMLPanel("<hr />textarea"));
    inRoot.add(textArea);

    textArea.setStyleName("textboxStyle");
    textArea.getElement().getStyle().setOverflow(Overflow.AUTO);
    textArea.getElement().setAttribute("wrap", "off");

    textArea.setVisibleLines(1);

    textArea.addChangeHandler(new ChangeHandler()
    {

      @Override
      public void onChange(ChangeEvent event)
      {
        System.out.println("Value changed");
      }
    });

    textArea.addKeyPressHandler(new KeyPressHandler()
    {
      @Override
      public void onKeyPress(KeyPressEvent event)
      {
        int lines = 0;
        final String s = textArea.getText();
        for (int i = 0; i != -1; i = s.indexOf("\n", i + 1))
        {
          lines++;
        }

        if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER)
        { // User hit "Enter"
          // key
          lines++;
        }
        textArea.setVisibleLines(lines);
      }
    });
  }

  private void addTableView(RootPanel inRoot)
  {
    final TableView table = new TableView();
    inRoot.add(new HTMLPanel("<hr />TableView with sort"));
    inRoot.add(new ToggleButton("On", "Off", new ClickHandler()
    {
      @Override
      public void onClick(ClickEvent inEvent)
      {
        boolean down = ((ToggleButton) inEvent.getSource()).isDown();
        table.setSortable(!down);
      }
    }));
    inRoot.add(table);

    final PosLabel l0 = new PosLabel("Hello0");
    final PosLabel l1 = new PosLabel("Hello1");
    final PosLabel l2 = new PosLabel("Hello2");
    final PosLabel l3 = new PosLabel("Hello3");
    final PosLabel l4 = new PosLabel("Hello4");
    final PosLabel l5 = new PosLabel("Hello5");

    table.setWidget(0, 0, l0);
    table.setWidget(1, 0, l1);
    table.setWidget(2, 0, l2);
    table.setWidget(3, 0, l3);
    table.setWidget(4, 0, l4);
    table.setWidget(5, 0, l5);

    table.setSortable(true);
    table.setSortedCallBack(new CallBack<Void>()
    {
      @Override
      public void onCallBack(Void inResult)
      {
        consoleNative("Sorted " + l0 + " " + l1 + " " + l2 + " " + l3 + " " + l4 + " " + l5);
      }
    });
  }

  private class PosLabel extends Label implements HasPosition
  {
    int mPos;

    public PosLabel(String inText)
    {
      super(inText);
    }

    @Override
    public String toString()
    {
      return getText() + ": " + mPos;
    }

    @Override
    public void setPos(int inPos)
    {
      mPos = inPos;
    }

    @Override
    public int getPos()
    {
      return mPos;
    }
  }

  private void dndTree(RootPanel inRoot)
  {
    Tree tree = new Tree();

    // root is not draggable.
    TreeItem treeroot = new TreeItem(new DragDropLabel("root", false, true));
    tree.addItem(treeroot);

    // Add some folders
    treeroot.addItem(new DragDropLabel("folder1", true, true));
    treeroot.addItem(new DragDropLabel("folder2", true, true));

    TreeItem folder3 = treeroot.addItem(new DragDropLabel("folder3", true, true));
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

    inRoot.add(new HTMLPanel("<hr />tree"));
    inRoot.add(tree);
  }

  private void addDndControllerWithFlexTable(RootPanel inRoot)
  {
    final TableView table = new TableView();

    inRoot.add(new HTMLPanel("<hr />DndController with TableView"));
    inRoot.add(table);

    DndController<FlowPanel> dnd = new DndController<FlowPanel>()
    {
      @Override
      public void removeAll()
      {
        table.clear();
      }

      @Override
      public void add(FlowPanel inWidget)
      {
        table.setWidget(table.getRowCount(), 0, inWidget);
      }
    };
    dnd.setOnMouseMoveAttribute(true);
    dnd.getWatch().remove(MouseMoveEvent.getType());

    FlowPanel item0 = new FlowPanel();
    item0.add(new InlineLabel("Hello"));
    item0.add(new InlineLabel("World 00"));
    dnd.putIn(item0);

    FlowPanel item1 = new FlowPanel();
    item1.add(new InlineLabel("Hello"));
    item1.add(new InlineLabel("World 01"));
    dnd.putIn(item1);

    FlowPanel item2 = new FlowPanel();
    item2.add(new InlineLabel("Hello"));
    item2.add(new InlineLabel("World 02"));
    dnd.putIn(item2);

    FlowPanel item3 = new FlowPanel();
    item3.add(new InlineLabel("Hello"));
    item3.add(new InlineLabel("World 03"));
    dnd.putIn(item3);

    FlowPanel item4 = new FlowPanel();
    item4.add(new InlineLabel("Hello"));
    item4.add(new InlineLabel("World 04"));
    dnd.putIn(item4);

    FlowPanel item5 = new FlowPanel();
    item5.add(new InlineLabel("Hello"));
    item5.add(new InlineLabel("World 05"));
    dnd.putIn(item5);
  }

  private void addDndControllerWithListGroupView(RootPanel inRoot)
  {
    final ListGroupView group = new ListGroupView();

    inRoot.add(new HTMLPanel("<hr />DndController with ListGroupView"));
    inRoot.add(group);

    final ListGroupItem mGhost = new ListGroupItem();
    mGhost.setStyleName("sortplaceholder");

    DndController<ListGroupItem> dnd = new DndController<ListGroupItem>()
    {
      @Override
      public void removeAll()
      {
        group.clear();
      }

      @Override
      public void add(ListGroupItem inItem)
      {
        group.add(inItem);
      }
    };

    ListGroupItem i0 = new ListGroupItem();
    FlowPanel f0 = new FlowPanel();
    f0.add(new Label("hello0"));
    i0.add(f0);
    dnd.putIn(i0);

    ListGroupItem i1 = new ListGroupItem();
    FlowPanel f1 = new FlowPanel();
    f1.add(new Label("hello1"));
    i1.add(f1);
    dnd.putIn(i1);

    ListGroupItem i2 = new ListGroupItem();
    FlowPanel f2 = new FlowPanel();
    f2.add(new Label("hello2"));
    i2.add(f2);
    dnd.putIn(i2);

    ListGroupItem i3 = new ListGroupItem();
    FlowPanel f3 = new FlowPanel();
    f3.add(new Label("hello3"));
    i3.add(f3);
    dnd.putIn(i3);

    ListGroupItem i4 = new ListGroupItem();
    FlowPanel f4 = new FlowPanel();
    f4.add(new Label("hello4"));
    i4.add(f4);
    dnd.putIn(i4);
  }

  private void addListGroupViewWithSortAbility(RootPanel inRoot)
  {
    inRoot.add(new HTMLPanel("<hr />ListGroupView with sort ability and placeholder"));

    final ListGroupDisplay group = new ListGroupView();
    inRoot.add(group);

    FlowPanel f0 = new FlowPanel();
    f0.add(new Label("hello-0"));
    group.add(f0);

    FlowPanel f1 = new FlowPanel();
    f1.add(new Label("hello-1"));
    group.add(f1);

    FlowPanel f2 = new FlowPanel();
    f2.add(new Label("hello-2"));
    group.add(f2);

    FlowPanel f3 = new FlowPanel();
    f3.add(new Label("hello-3"));
    group.add(f3);

    FlowPanel f4 = new FlowPanel();
    f4.add(new Label("hello-4"));
    group.add(f4);

    group.makeSortable();
    group.setSortedCallBack(new CallBack<String[]>()
    {
      @Override
      public void onCallBack(String[] inResult)
      {
        Growl.growl("resorting complete: " + inResult);
      }
    });
  }

  private String newPerson(String inString, int inI)
  {
    return inString;
  }

  public static native void consoleNative(String inMessage)
  /*-{
     console.log(inMessage);
  }-*/;

  public static native void consoleClearNative()
  /*-{
     console.clear();
  }-*/;
}