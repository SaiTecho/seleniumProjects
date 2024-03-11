 In this Repo im adding selenium Projects ...
 
 
 
******************************************************************************************************************

How to find element using xpath:-
-------------------------------------------------------------------------------------------------------------------------------------

starts-with  --->	//tagname[starts-with(@Attribute,'value')]

contains   	 --->	//tagname[contains(@Attribute,'value')]

text         --->	//tagname[text()='value']

or     		 --->	//tagname[@Attribute='value' or @Attribute='Value']

and     	 --->	//tagname[@Attribute='value' and @Attribute='Value']


Axes Methods in xpath
-------------------------------------------------------------

parent  --->	//tagname[@Atrribute='Value']//parent::tagname

child   --->	//tagname[@Atrribute='Value']//child::tagname

descendent ,ancestor

following ,following-sibling

preceding ,preceding-sibling   --- when we have same tagname 

**********************************************************************************************************************

How to find element using cssSelector:-
---------------------------------------------------------------------------------------------------------

css selectores

---------------------

normalsyntax ---> tagname[attributename='attributeValue']



select by id ---> tagname#elementid  or #elementid

select by class ---> tagname.elementid or .elementid

tagname.classvalue[attributename='attributeValue'] 
tagname#idvalue[attributename='attributeValue']

^ --> prefix

$ --> suffix 

* ---> subtring of the text

tagname[attributeName^='attribute value starts with']

tagname[attributeName$='attribute value ends with']

tagname[attributeName*='attribute value that contains text']



(>) greater than symbol ---> Direct child 

( ) space 						---> child or subchild

(+) plus symbol  ---> adjacent sibling



pseudo classes

------------------

first-child   -->  :first-child

last-child  --> :last-child

nth-child  ---> :nth-child(specify the number)

nth-last-child  --> :nth-last-child(specify the number)

first-of-type

last-of-type

nth-of-type()

**************************************************************************************************



 