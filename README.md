# Java_OOP_Five

## abstract data type (ADT) for a linked list

### Problem
You are to implement the abstract data type (ADT) for a linked list, which is an interface containing the signatures for the methods/operations that can be performed on the linked list. The given interface contains an object data type, which will be stored in the linked list and is to be considered when implementing the linked list. In this assignment, we have string objects and user object. <br/>
The linked list is to be a singly-linked list with a head and optionally a tail. Each method should be completely implemented, and any exceptions are to be appropriately propagated. Given also a class, which represents a node in the linked list. <br/>
The given linked list interface will contain the following functionality (Don’t use already implemented classes/methods/libraries for the following functionalities):<br/>
•	Prepend an item to the beginning of the linked list.<br/>
•	Append an item to the end of the linked list.<br/>
•	Insert an item at a specific index in the linked list.<br/>
•	Replace an item in the linked list.<br/>
•	Retrieve an item at an index in the linked list.<br/>
•	Get the index of an item in the linked list.<br/>
•	Check if a linked list has an item.<br/>
•	Clear all items in the linked list.<br/>
•	Get the number of items in the linked list.<br/>
•	Delete an item at an index in the linked list.<br/><br/>
The supplied interface will be placed in the contracts package, the implemented linked list class will be placed in the managers package and the node class will be placed in the problemdomain package.<br/>

### JUnit Testing
Supplied is a test suite that performs unit testing on an implemented linked list. The test cases of “test-to-pass” have been implemented. You are not to modify the implemented test cases. You are to come up with and implement: 1) other missing test cases (test-to-pass); and 2) other test cases (test-to-fail) for all methods. <br/>
The following JUnit test cases (test-to-pass) have been provided:<br/>
•	The linked list is empty.<br/>
•	An item is prepended.<br/>
•	An item is appended.<br/>
•	An item is inserted at index.<br/>
•	An item is replaced.<br/>
•	An item is deleted.<br/>
•	An existing item is found and retrieved.<br/><br/>
You should include a screenshot showing your JUnit test case results in your submission.<br/>

### Serialization
The implemented linked list will need to be serialized. You will need to follow the steps needed to make an object serialized. An object of the linked list will be able to be stored a binary file. The object will be able to be reconstructed from its binary file.<br/>
The supplied User class in the problemdomain package will be used as the data type for the items in the linked list. You need to serialize this class as well, but not all the information for a user should be included in the serialization process. You will need to determine what information is not to be serialized and implement the changes, so it is ignored in the serialization. You need to implement the JUnit test cases (test-to-pass only) for the user class. Note that the linked list will need to be set to run these serialization JUnit test cases and besides this, there are no changes to be made to the JUnit test cases (i.e., all JUnit test cases will need to pass with no errors given). You are required to include a screenshot showing the JUnit test case results for serialization. <br/>

### Details:
JUnit test cases for serializing the user class:<br/>
1)	Should be in the SerializationPassTests class.<br/>
2)	Do not check if the not serialized information is not included.<br/>
3)	Should has an init () method to do the required initialization and to create object from the linked list class and four objects from the user class with the following information: <br/>
A.	User(1, "Joe Blow", "jblow@gmail.com", "password")); <br/>
B.	User(2, "Joe Schmoe", "joe.schmoe@outlook.com", "abcdef")); <br/>
C.	User(3, "Colonel Sanders", "chickenlover1890@gmail.com", "kfc5555")); <br/>
D.	User(4, "Ronald McDonald", "burgers4life63@outlook.com", "mcdonalds999"));<br/>
4)	Should has a JUnit test case to check if the serialization process is function correct (i.e., test-to-pass). <br/>
5)	Should has a JUnit test case to check if the deserialization process is function correct (i.e., test-to-pass).<br/>
6)	Should has a tearDown () method to call the clear() method to clear the linked list and to close all opened streams<br/>
