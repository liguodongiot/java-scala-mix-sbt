package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object ChooseCollectionClass extends App{

  //  • Sequence
  //  • Map
  //  • Set

  //Scala通用的（可变、不可变）的有序集合
  //                          Immutable       Mutable
  //  Indexed                 Vector          ArrayBuffer
  //  Linear (Linked lists)   List            ListBuffer



  //主要的不可变序列选择
  //IndexedSeq    Range String  Vector
  //LinearSeq     List  Queue   Stack   Stream

  //主要的可变序列选择
  //IndexedSeq    ArrayStack  StringBuilder
  //LinearSeq     DoubleLinkedList  LinkedList  ListBuffer  MutableList Queue Stack


  // Traits commonly used in library APIs
  //IndexedSeq  Implies that random access of elements is efficient.
  //LinearSeq   Implies that linear access to elements is efficient.
  //Seq         Used when it isn’t important to indicate that the sequence is indexed or linear in nature.

  //可变和不可变Map的选择
  //                  Immutable   Mutable
  //      HashMap         -         -
  //      LinkedHashMap             -
  //      ListMap         -         -
  //      Map             -         -
  //      SortedMap       -
  //      TreeMap         -
  //      WeakHashMap               -

  //可变和不可变Set的选择
  //                  Immutable   Mutable
  //    BitSet            -          -
  //    HashSet           -          -
  //    LinkedHashSet                -
  //    ListSet           -
  //    TreeSet           -          -
  //    Set               -          -
  //    SortedSet         -          -


  //Other collections classes (and types that act like collections)
  //  Enumeration
  //  Iterator
  //  Option
  //  Tuple


  //other useful collection types [Stack, Queue, and Range]

  // a few other classes that act like collections,
  // including tuples, enumerations, and the Option/Some/None
  //and Try/Success/Failure classes.


  //Choosing a sequence
  //索引序列
  //IndexedSeq
  //线性序列
  //LinearSeq



  //Choosing a map



  //Choosing a set


}
