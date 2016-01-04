# pa2015-classdiagram
**Projecto PA - UML Class Diagram Plugin**

The project "pa.iscde.classdiagram" is the *[PIDESCO](https://github.com/andre-santos-pt/pidesco)* module for displaying class diagrams.

The Class Diagrams displayed by this plugin are generated using selected class on the browser view. In addiction, if a package is double-clicked, all the classes directly bellow it, are rendered as diagrams.

##Extension Points
The plugin may be extended using 2 main extension points: **Filter** and **Action** extensions.

For more info on how to implement the extension points see the [Wiki](https://github.com/jcarias/pa2015-classdiagram/wiki)!

###The Filter Extension Point
By default, all classes and all it's elements are displayed. <br>
In order to restrain which classes/elements should be displayed, users can add filters to the plugin. <br>
The filters need to define which *TopElements* (Classes, Interfaces, Enums, etc.), can be displayed, and for those, which *ChildElements* (Attributes or Methods) will also by displayed.<br>
Note: the filters will can be activated/deactivated globally using the toggle button on the top of the Class Diagram View, ou individually using the context menu of the diagram window.


###The Action Extension Point
(TODO: Provide short description here)


##Extensions to other plugins
This plugin is going to extend two other existing plugins: [DeepSearch](https://github.com/RitaRamo/pa.iscde.deepsearch.git)(**deepsearch.event**) and [Package Dependencies](https://github.com/Joao-Andrade/pa2015-Packdep) (**packdep.action**)
 

###The ***deepsearch.event*** Extension
This "Extension" is actually a service provided by the DeepSearch Plugin containing info about the search terms and the results found. In the class diagram it will be used to highlight the class elements being currently displayed that match the search criteria.


###The ***packdep.action*** Extension
(TODO: Provide short description here)

