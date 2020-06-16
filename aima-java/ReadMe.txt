AIMA JAVA Notes By Ravi(magesmail@yahoo.com) and Ciaran (ctjoreilly@gmail.com).

NOTE: This branch is no longer supported. Release 0.95 is the final release based on the 2nd edition of the book.

#Some Notes

= Introduction =
The latest  (and ever evolving) code can be found at http://code.google.com/p/aima-java/. if you notice a bug please try checking out the latest  version from the svn repository to  see if it persists.

Current release is 0.95:<br>
This is our first release containing GUIs (thanks to Ruediger Lunde):<br>
  - aima.gui.applications.VacuumAppDemo<br>
    Provides a demo of the different agents described in Chapter 2 and 3
    for tackling the Vacuum World.<br>
  - aima.gui.applications.search.map.RoutePlanningAgentAppDemo<br>
    Provides a demo of the different agents/search algorithms described 
    in Chapters 3 and 4, for tackling route planning tasks within 
    simplified Map environments.<br>
  - aima.gui.framework.SimpleAgentAppDemo<br>
    Provides a basic example of how to create your own Agent based 
    demonstrations based on the provided framework.<br>
<br>    
This will also be our last full release based on the 2nd edition of AIMA. 
We are currently in the planning phases to re-organize this project based on the 3rd edition of AIMA, which should be available soon.

Previous release is 0.94:<br>
This is a patch release for the FOL Logic and includes the following fixes:<br>
  - Fixed subtle defect in Model Elimination inference algorithm, which caused it to miss portions of the search space.<br>
  - Improved the performance of both theorem provers, in particular added support for forward and backward subsumption elimination, which improves significantly the performance and use of the OTTER Like theorem prover.<br>
  - Fixed defect in cascade occurs check in unifier logic.<br>

Previous release is 0.93:<br>
It includes:<br>
  - a completion of the First Order Logic concepts from Chapter 9.<br>
  - the addition of the LRTA Agent from Chapter 4.<br>

  Note: If running the unit tests be sure to include the vm arguments:
  -Xms256m -Xmx1024m
  as some of the First Order Logic algorithms (i.e. FOLTFMResolution) are
  memory hungry.

Previous release is 0.92:<br>

It includes a rewrite of the neural network algorithms (in the earlier version the nn s were getting saturated because the data was not pre processed)
 +  more algorithms  from chapter 4.
 
Heuristics are now doubles (vs ints in the old version).
One minor change is that I've dropped the make file. Please use [http://ant.apache.org/ant  ant]

==Bug Reports - acknowledgment ==

The following people sent in excellent comments and bug reports. Thank you!!!!<br>
  * Ali Tozan<br>
  * Carl Anderson, Senior Scientist, ArchimedesModel.com<br>
  * Don Cochrane from (?) University<br>
  * Mike Angelotti  from Miami University<br>
  * Chad Carff ,University of Western Florida .  EXCELLENT test cases . thank you.<br>
  * Dr .Eman El-Sheikh, Ph.D.,University of Western Florida<br>
  * Ravindra Guravannavar, Aztec Software,Bangalore<br>
  * Cameron Jenkins,University Of New Orleans<br>
  * Nils Knoblauch (Project Manager, Camline) - winner of the No Prize for the best bug report ! Thanks!<br>
  * Phil Snowberger, Artificial Intelligence and Robotics Laboratory,University of Notre Dame<br>

= Details =

==Build Instructions==
If you just want to use the classes, all you need to do is put the aima-java/build directory on your CLASSPATH.

if you want  to rebuild from source, run the unit tests etc follow the instructions below.

you need [http://ant.apache.org/ ant] to build from source.

Many IDE's have built in ant versions. So you may want to try that first. 

To build from the command line,

 # download the archive.
 # unzip
 # confirm that the aima-java/build directory is on your CLASSPATH
 # go to the aima-java directory
 # put [http://prdownloads.sourceforge.net/junit/junit3.8.1.zip?download junit 3.8.1 (note the version number)] on the classpath
 # type 'ant' 

I have included the eclipse.classpath and .projectfiles for those who use [http://www.eclipse.org eclipse] .

==Code Navigation==
 # To understand how a particular feature works , FIRST look at the demo files.There are four main demo files  SearchDemo , LogicDemo ,ProbabilityDemo and LearningDemo.
 # If the Demo Files don't exist yet , look at the unit tests . they often cover much of how a particular feature works . 
 # If all else fails , write to me . Comprehensive documentation, both java doc and otherwise are in the pipeline , but will probably have to wait till I finish the code .

==Notes on Search==

To solve a problem with (non CSP )Search .
   # you need to write four classes .
	 # a class that represents the Problem state .This class is independent of the framework and does NOT need to subclass anything . Let us, for the rest of these instruction, assume you are going to solve the NQueens problem . So in this step you need to write something like aima.search.nqueens.NQueensBoard . 
	 # a subclass of aima.search.framework.GoalTest.This implements only a single function ---boolean isGoalState(Object state); The parameter state is an instance of the class you created in  step 1-a above. For the NQueensProblem you would need to write something like aima.search.nqueens.NqueensBoardTest
	 # a subclass of aima.search.framework.SuccessorFunction .This generates a stream of Successors where a Successor is an object that represents an (action, resultantState) pair. In this release of the code the action is  a String (something like "placeQueenAt4,4" and the resultant State is an instance of the class you create in step 1.a . An example is aima.search.nqueens.NQueensSuccessorFunction.
	 # If you need to do an informed search, you should create a fourth class which subclasses aima.search.framework.HeuristicFunction. This implements a single function  int getHeuristicValue(Object state); keep in mind that the heuristic should DECREASE as the goal state comes nearer .  For the NQueens problem, you need to write something like aima.search.nqueens.QueensToBePlacedHeuristic.

that is all you need to do (unless you plan to write a different search than is available in the code base ).

To actually search you need to
   # configure a problem instance
   # select a search .Configure thsiwith Tree Search or GraphSearch if applicaple.
   # instantiate a SerachAgent and 
   # print any actions and metrics 

A good example (from the NQueens Demo ) is 
{{{

  private static void nQueensWithDepthFirstSearch() {
       System.out.println("\nNQueensDemo DFS -->");
        try {
                //Step a
                 Problem problem =  new Problem(new NQueensBoard(8),new NQueensSuccessorFunction(), new NQueensGoalTest());
                 //Step b
                 Search search = new DepthFirstSearch(new GraphSearch());
                //Step c
                SearchAgent agent = new SearchAgent(problem, search);
               //Step d
               printActions(agent.getActions());
               printInstrumentation(agent.getInstrumentation());
       } catch (Exception e) {
			       e.printStackTrace();
			      }
	}
}}}

==Search Inheritance Trees ==

there are two inheritance trees in Search. one deals with "mechanism" of search.

This inheritance hierarchy looks like this

 ||[http://aima-java.googlecode.com/svn/trunk/src/aima/search/framework/NodeExpander.java NodeExpander] (encapsulates the Node expansionmechanism)||---||---||
 ||---|| [http://aima-java.googlecode.com/svn/trunk/src/aima/search/framework/QueueSearch.java QueueSearch]||---||
 ||---||---||[http://aima-java.googlecode.com/svn/trunk/src/aima/search/framework/GraphSearch.java GraphSearch]||
 ||---||---||[http://aima-java.googlecode.com/svn/trunk/src/aima/search/framework/TreeSearch.java TreeSearch]||

The second tree deals with the search instances  you can use to solve a problem.These implement the aima.search.framework.Search interface.

||Search||---||---||---||
||---||BreadthFirstSearch||---||---||
||---||DepthFirstSearch||---||---||
||---||HillClimbingSearch||---||---||
||---||PrioritySearch||---||---||
||---||---||AStarSearch||---||

etc

So if you see a declaration like 
"SimulatedAnnealingSearch extends NodeExpander implements Search" , do not be confused.
	
the  superclass ([http://aima-java.googlecode.com/svn/trunk/src/aima/search/framework/NodeExpander.java NodeExpander]) provides the mechanism of the search and the interface (Search) makes it suitable for use in solving actual problems .

Searches like DepthFirstSearch which need to be used as a search (so implementing the Search interface) and can be configured with either Graphseach or TreeSearch (the mechanism) have a  constructor like
	 public DepthFirstSearch(QueueSearch search) .

Again, if you get confused, look at the demos.


==Logic Notes==
The ONE thing you need to watch out for is that the Parsers are VERY finicky . If you get  a lexing or parsing error, there is a high probability there is an error in your logic string.

To use First Order Logic, first you need to create a subclass of aima.logic.fol.FOLDomain which collects the constants, predicates, functions etc that you use to solve a particular problem.

A parser (that understands the Grammar in figure 8.3 (page 247 in my copy) ) needs to be instantiated with this domain (eg: 
FOLDomain weaponsDomain = DomainFactory.weaponsDomain();
FOLParser parser = new FOLParser(weaponsDomain);  ).

the basic design of all the logic code is that the parser creates a Composite (Design Patterns by Gamma, et al) parse tree over which various Visitors(Design Patterns by Gamma, et al) traverse . the key difference between the Visitor elucidated in the GOF book and the code is that in the former the visit() methods have a void visit(ConcreteNode) signature while the visitors used in the logic code have a Object visit(ConcreteNode,Object arg) signature. This makes testing easier and allows some recursive code that is hard with the former .

==Probability Notes==

Except elimination-ask, the rest of the algorithms from chapter 13 and 14 have been implemented. I have tried to make the code stick very closely to Dr.Norvig's' pseudocode . Looking at the demo and tests will reveal how to use the code . 

==LearningNotes==

===Main Classes and responsibilities===
A <DataSet> is a collection of <Example>s .Wherever you see "examples" in plural in the text , the code uses a DataSet . This makes it easy to aggregate operations that work on collections of examples in one place.

An Example is a collection of Attributes. Each example is a data point for Supervised Learning .

DataSetSpecification and AttributeSpecification do some error checking on the attributes when they are read in from a file or string .At present there are two types of Attributes - A sring attribute, used for datasets like "restaurant" and a NUmeric Attribute which represents attributes which are numbers . These are presently modelled as Doubles.

A Numerizer specifies how a particular DataSet's examples may be converted to Lists of DOubles so they can be used in Neural Networks . There is presently one numerizer in the codebase (IrisDataSetNumerizer)  but it is trivial to write more by implementing the Numerizer interface.

===how to apply learners===

The DecisionTreeLearner and DecisionList Learner work only on datasets with ordinal attributes (no numbers).Numbers are treated as distinct strings.

The Perceptron and DecisionTreeLearners work on *numerized datasets* .If you intend to work with these, you need to write a DataSetSpecific Numerizer by implementing the Numerizer interface.

1.To import a dataset into a system so that learners can be applied to it , first add a public static DataSet getXDataSet(where "x" is the name of the DataSet you want to import) to the DataSetFactory

2.Learners all implement the Learner interface with 3 methods, train, predict and test. If you want to add a new type of Learner (a partitioning Decision Tree learner perhaps? )  you need to implement this interface .

 LearningDemo.java contains examples of how to use all the learners . LearnerTests may be of help too. There are specific test files for Decison Trees, Decision Lists and Neural networks.


#Probabilistic Decision Making and  reinforcement learning
TBD
 
==Final Thoughts==

If you need any help with the java code, do write to me at magesmail@yahoo.com.

I am happy to receive any mails/bug reports and generally respond within a day, unless I am travelling .The only mails I do NOT respond to are those asking me to do your homework! Don't even try ! :-) These  mails are rejected without even reading them! 


Bug Reports are greatly appreciated! 

when you send in a bug report please include
     # what you did to see the bug
     # what you expected to see
     # what you actually saw.

 
A bug report that says "there is some bug in Search" (I actually got a mail like this) is next to useless.
