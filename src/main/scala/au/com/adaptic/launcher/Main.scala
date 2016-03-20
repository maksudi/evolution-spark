package main.scala

/**
 * 
 */


object Main {
  type Data = List[Int]
  type AlgorithmResult = Double
  type Solution = Double
  type EvalFunction = Solution => Double
  type Algorithm = Data => EvalFunction => AlgorithmResult
  
  
  class Individual{
  }
  
//  class SimpleIndividual extends List[Int] {
//    
//  }
  
  type Population = Seq[Individual]
  type SelectionPool = List[Individual]
  type Selection = Population => SelectionPool //need type safety for Selection pool here
}