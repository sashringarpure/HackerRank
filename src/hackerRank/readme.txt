Processes/QMS/Introduced CCB process, Architecture, Planning, Agile, Branching, CI/CD, Automations, Test Report, Test Rails, Release, Resources (Neerupa, Sini, Mdas)
Collections:
    Initializations:
        HashSet<Integer> hs = new HashSet<Integer>();
        Set<Integer> random = new HashSet<Integer>();
        TreeSet<Integer> ts = new TreeSet<Integer>();
        SortedSet<Integer> ss = new TreeSet<Integer>(); //HashSet does not produce a sorted set due to hashing mechanism.
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        Hashtable<Integer,Integer> ht = new Hashtable<Integer, Integer>();
        TreeMap<Integer,Integer> tm = new TreeMap<Integer, Integer>();
        Map<Integer,Integer> m = new HashMap<Integer, Integer>();
        LinkedList<String> ll = new LinkedList<String>();
    HashSet/TreeSet Iterator:
        Iterator hsi = hs.iterator();
        Iterator tsi = ts.iterator();
    List/LinkedList Iterator:
        ListIterator<String> li = ll.listIterator();
    Array Sort:
        Arrays.sort(<<array_name>>);
        Arrays.sort(<<array_name>>, Collections.reverseOrder);
    List Sort:
        Collections.sort(<<list_name>>); //for list
        Collections.sort(<<list_name>>,Collections.reverseOrder);  //for list
    Iterate HashMap:
        Map<String,String> gfg = new HashMap<String,String>();
          for (Map.Entry<String,String> entry: gfg.entrySet()) ) => entry.getKey(); entry.getValue();
          for (String s : gfg.keySet() )
          for (String s : gfg.values() )
          Iterator<Map.Entry<String,String>> i = gfg.entrySet.iterator(); ==> while ( i.hasNext() ) {}
          gfg.containsKey(Object); gfg.put(<<key>>,<<value>>);
    Sort a map by Keys:
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        Map<Integer, String> m3 = new TreeMap<Integer, String>(map);
        Set s1 = m3.entrySet();
        Iterator it = s1.iterator();
        while (it.hasNext()) {
        	Map.Entry me = (Map.Entry) it.next();
        	System.out.print(me.getKey()+"="+me.getValue());
        }
    Sort a map by values:
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        List<Map.Entry<Character,Integer>> ll = new LinkedList<Map.Entry<Character,Integer>> (map.entrySet);
        Collections.sort(ll, new Comparator<Map.Entry<Character,Integer>> () {
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        HashMap<Character,Integer> m4 = new LinkedHashMap<Character, Integer>();
        Iterator it1 = ll.iterator();
        while (it1.hasNext()) {
        	Map.Entry entry = (Map.Entry) it1.next();
        	m4.put((Character) entry.getKey(), (Integer) entry.getValue());
        }
    Convert Map to EntrySet:
        HashMap<String, String> map = new HashMap<>();
        List<Map.Entry<String,String>> ll = new LinkedList<Map.Entry<String,String>>(map.entrySet());
    Sorted Set Descending order:
        Set<Integer> random = new HashSet<Integer>(); Set<Integer> sorted = new TreeSet<Integer>(new Comparator<Integer>() {@Override
                                                                                                                                        public int compare(Integer o1, Integer o2) {
                                                                                                                                            return o2.compareTo(o1);
                                                                                                                                        }
                                                                                                                                    }); sorted.addAll(random);
    Array Copy:
        System.arraycopy(nums,0,integer,0,nums.length);
    Arrays to List:
        Arrays.asList(<<array_name>>);
    Convert int to Integer:
        Integer integer;
        for ( int i : nums ) { integer = (Integer) i; }
    Convert int[] to List[]:
        List arrayList = Arrays.asList(nums);
     Cast Object to int:
        int[] out = new int[nums.length];
        out[counter] = (Integer) arrayList.get(0);
    Selenium:
        Support Classes:
            Quotes.escape
            Colors:
                final WebElement title = driver.findElement(By.id("abc"));
                final Color blackValue = Colors.BLACK.getColorValue();
                final Color redValue = new Color(255,0,0,1);
                Assertions.assertEquals(title.getCssValue("color"), redValue.asRgba());
            Select:
                final WebElement selectMenu = driver.findElement(By.id("abc"));
                final Select select = new Select(selectMenu);
                select.selectByVisualText("abc");
                Assertions.assertEquals(3, select.getFirstSelectedOption().getAttribute("value");
                List<WebElement> options = select.getOptions();
                new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.id("abc"), "test message"));
            Locators:
                ByIdOrName
                ByAll:
                    final List<WebElement> buttons = driver.findElements(new ByAll(By.id("abc"),By.Name("abc")));
                ByChained:
                    final List<WebElement> buttons = driver.findElements(new ByChained(By.id("abc"),By.Name("abc")));
                ByAttributeValue:
                    private class ByAttributeValue extends By {
                        private final String name;
                        private final String value;

                        public ByAttributeValue(String attributeName, String attributeValue) {
                            this.name = attributeName;
                            this.value = attributeValue;
                        }

                        @Override
                        public List<WebElements> findElements(SearchContext context) {
                            return context.findElements(By.cssSelector(String.format("[%s='%s']", name, value)));
                        }
                    }

                    private class ByGlobalDataAttribute extends By {
                        private final String name;
                        private final String value;

                        public ByAttributeValue(String attributeName, String attributeValue) {
                               this.name = attributeName;
                               this.value = attributeValue;
                        }

                        @Override
                        public List<WebElements> findElements(SearchContext context) {
                                return context.findElements(By.cssSelector(String.format("[data-%s='%s']", name, value)));
                        }
                    }

                    WebElement title = driver.findElement(new ByGlobalDataAttribute("title","historytitle));
            Synchronization:
                WebDriverWait:
                    WebDriverWait wait = new WebDriverWait(driver, 10);
                    WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#abc")));
                Custom ExpectedConditions:
                    private ExpectedCondition<Boolean> historyMessagesIncreaseInNumber() {
                        return new ExpectedCondition<Boolean>() {
                            private int initialCount = driver.findElements(By.cssSelector("#li.message")).size();
                            @Override
                            public Boolean apply(WebDriver webDriver) {
                                int currentCount = driver.findElements(By.cssSelector("#li.message")).size();
                                return currentCount > initialCount;
                            }
                        }
                    }
                    new WebDriverWait(driver, 10).until(historyMessagesIncreaseInNumber());
                    WebElement message = driver.findElement(By.cssSelector("#li.message"));
                Custom FluentWait:
                    WebElement singleListParent = driver.findElement(By.id("single-list"));

                    FluentWait wait = new FluentWait<WebElement>(singleListParent).withTimeOut(Duration.ofSeconds(10)).
                        pollingEvery(Duration.ofSeconds(10)).withMessage("abc").
                        ignoring(StaleElementReferenceException.class).until(ExpectedConditions.
                        visibilityOfElementLocated(By.cssSelector("#li.message")));

                    wait.until(new HistoryMessagesIncreaseInNumber(0));

                    private class historyMessagesIncreaseInNumber implements Function<WebElement, Boolean> {
                        private final int initialCount;
                        public historyMessagesIncreaseInNumber(int count) {
                            this.initialCount = count;
                        }

                        @Override
                        public Boolean apply(final WebElement element) {
                            int current count = element.findElements(By.cssSelector("#li.message")).size();
                            return currentCount>initialCount;
                        }
                    }
            AjaxElementLocatorFactory:
                initElements(new AjaxElementLocatorFactory(driver, 10));
            Custom AjaxElementLocatorFactory:
                initElements(new VisibleAjaxElementFactory(driver, 10));

                public class VisibleAjaxElementFactory implements ElementLocatorFactory {
                    private final WebDriver driver;
                    private final int timeOutInSeconds;

                    public VisibleAjaxElementFactory(WebDriver driver, int timeOutInSeconds) {
                        this.driver = driver;
                        this.timeOutInSeconds = timeOutInSeconds;
                    }

                    @Override
                    public ElementLocator createLocator(Field field) {
                        return new VisibleAjaxElementLocator(driver, field, timeOutInSeconds);
                    }

                    private class VisibleAjaxElementLocator extends AjaxElementLocator {
                        public VisibleAjaxElementLocator(WebDriver driver, Field field, int timeOutInSeconds) {
                            super(driver, field, timeOutInSeconds);
                        }
                        @Override
                        protected boolean isElementUsable(WebElement element) {
                            if(element==null) return false;
                            return element.isDisplayed && element.isEnabled();
                        }
                    }
                }
            FindBys:
                @FindBys({
                    @FindBy(how=How.Id, using="single"),
                    @FindBy(how=How.CLASS_NAME, using="class-name")
                })
                List<WebElement> singleMessages;
            SlowLoadableComponent:
                public class MessageHistoryPage extends SlowLoadableComponent {

                    @FindBy(how = How.CSS, using="#abc")
                    List<WebElement> multiMessages;

                    @FindBy(how = How.CSS, using="#abc")
                    List<WebElement> singleMessages;

                    public MessageHistoryPage(final WebDriver driver) {
                        super(Clock.systemDefaultZone(), 10);
                        this.driver = driver;
                        PageFactory.initElements(driver, this);
                    }

                    @Override
                    protected void load() {
                        driver.get("https://www.google.com");
                    }

                    @Override
                    protected void isLoaded() throws Error {
                        boolean ready = false;
                        try {
                                ready = singleMessages.size() > 0 || multiMessages.size() > 0;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        if (!ready) {
                            throw new Error("Page not loaded.");
                        }
                    }
                }
            EventFiringWebDriver:
                @Test
                public void createFromAbstract() {
                    new EventFiringWebDriver events = new EventFiringWebDriver(driver);
                    events.register(new HighLighterEventListener());
                    events.register(new ScreenshotterEventListener());

                    final SimpleSupportPageObject page = new SimpleSupportPageObject(driver);
                    String message = page.chooseOption(4);
                    Assertions.assertEquals("Received message: selected 4", message);
                }

                public class HighLighterEventListener extends AbstractWebDriverEventListener {
                    private WebElement lastElement;


                    @Override
                    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
                        if(lastElement!=null) {
                            try {
                                ((JavascriptExecutor)driver).executeScript(
                                    "arguments[0].style.border='none'",lastElement
                                );
                            }catch(Exception e) {
                                e.printStackTrace();
                            }
                            lastElement = null;
                        }
                    }
                    @Override
                    public void afterFindBy(By by, WebElement element, WebDriver driver) {
                        lastElement = element;
                        ((JavascriptExecutor)driver).executeScript(
                            "arguments[0].style.border='10px dashed red'",element
                        );
                    }
                }

                public class ScreenshotterEventListener extends AbstractWebDriverEventListener {
                    @Override
                    public void afterFindBy(By by, WebElement element, WebDriver driver) {
                        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                        File screenshotFolder = new File(System.getProperty("user.dir"),"screenshots");
                        screenshotFolder.mkdirs();
                        try {
                            FileUtils.copyFile(screenshot, new File(screenshotFolder,
                                System.currentTimeMillis()+".png"));
                        } catch(Exception e) {
                           e.printStackTrace();
                        }
                    }
                }
