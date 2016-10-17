package scalacookbook.chapter10

/**
  * Created by liguodong on 2016/7/24.
  */
object ChooseCollectionMethodSolveProblem {

  //方法分类

  //过滤方法（过滤一个集合）
  // collect, diff, distinct,
  //  drop, dropWhile, filter, filterNot, find, foldLeft, foldRight, head,
  //  headOption, init, intersect, last, lastOption, reduceLeft, reduceRight,
  //  remove, slice, tail, take, takeWhile, and union.

  //转换方法（通常输入至少一个集合，输出一个新的集合）
  //  +, ++, −, −−, diff,
  //  distinct, collect, flatMap, map, reverse, sortWith, takeWhile, zip, and
  //  zipWithIndex.

  //分组方法（从一个集合创建多个组）
  //groupBy, partition, sliding, span, splitAt, and unzip.

  //信息和数学方法（提供一个集合的信息）
  //canEqual,contains, containsSlice, count, endsWith, exists, find, forAll, hasDefiniteSize,
  // indexOf, indexOfSlice, indexWhere, isDefinedAt, isEmpty,lastIndexOf, lastIndexOfSlice,
  // lastIndexWhere, max, min, nonEmpty, product, segmentLength, size, startsWith, sum.

  //foldLeft, foldRight, reduceLeft, and reduceRight


  //其他方法
  // par, view, flatten, foreach, and mkString.

  
  //Common methods on Traversable collections
  //      c collect f
  //      c count p
  //      c1 diff c2
  //      c drop n
  //      c dropWhile p
  //      c exists p
  //      c filter p
  //      c filterNot p
  //      c find p
  //      c flatten
  //        c flatMap f
  //      c foldLeft(z)(op
  //        c foldRight(z)(o
  //        c forAll p
  //        c foreach f
  //        c groupBy f
  //        c hasDefiniteSiz
  //        c head
  //        c headOption
  //        c init
  //        c1 intersect c2
  //        c isEmpty
  //        c last
  //        c lastOption
  //        c map f
  //        c max
  //        c min
  //  c nonEmpty
  //    c par
  //    c partition p
  //  c product
  //    c reduceLeft op
  //  c reduceRight op
  //  c reverse
  //    c size
  //    c slice(from, to
  //    c sortWith f
  //    c span p
  //    c splitAt n
  //    c sum
  //    c tail
  //    c take n
  //    c takeWhile p
  //    c1 union c2
  //    c unzip
  //    c view
  //    c1 zip c2
  //    c zipWithIndex











  //Common operators (methods) on mutable collections
  //  Operator (method)
  //  c += x
  //  c += (x,y,z)
  //  c1 ++= c2
  //  c −= x
  //  c −= (x,y,z)
  //  c1 −−= c2
  //  c(n) = x
  //  c clear
  //  c remove n
  //  c.remove(n, len)

  //Immutable collection operators
  //  Operator (method)
  //  c1 ++ c2
  //  c :+ e
  //  e +: c
  //  e :: list
  //  c drop n
  //  c dropWhile p
  //  c filter p
  //  c filterNot p
  //  c head
  //  c tail
  //  c take n
  //  c takeWhile p

  //Maps

  //  Map method
  //  Methods for immutable maps
  //  m - k
  //  m - (k1, k2, k3)
  //  m -- c
  //  m -- List(k1, k2)

  //  Methods for mutable maps
  //  mm += (k -> v)
  //  mm += (k1 -> v1, k2 -> v2)
  //  mm ++= c
  //  mm ++= List(3 -> "c")
  //  mm -= k
  //  mm -= (k1, k2, k3)
  //  mm --= c

  //  Methods for both mutable and immutable maps
  //  m(k)
  //  m contains k
  //  m filter p
  //  m filterKeys p
  //  m get k
  //  m getOrElse(k, d)
  //  m isDefinedAt k
  //  m keys
  //  m keyIterator
  //  m keySet
  //  m mapValues f
  //  m values
  //  m valuesIterator


}
