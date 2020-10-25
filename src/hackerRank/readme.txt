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
    Sort a map:
        HashMap<Integer, String> map = new HashMap<>(); TreeMap<Integer, String> treeMap = new TreeMap<>(map);
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
