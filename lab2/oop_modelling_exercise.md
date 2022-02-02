# OOP Modelling Exercise
The COVID-19 Task Force is developing a system to keep track of confirmed COVID-19 cases in Singapore.

Each confirmed case has an integer case id. 
- There are two types of confirmed cases: imported and local. 

For each imported case (and only imported case), the system keeps track of the country the case is imported from. 

For each confirmed case, the system keeps track of the contacts of the case. 
- A contact is another confirmed case (can be either local or imported). 

A case can have zero or more contacts. 
- Each contact is labelled with the nature of the contact, which can be either one of the three: casual contact, close contact, family member.

The cases can be grouped into clusters. 
- Each cluster has a name (a String). 
- A cluster can contain one or more cases. But a case might not necessarily belong to a cluster. 
- A case can belong to multiple clusters.

Important operations are:
- Given a cluster, find all cases in the cluster.
- Given a cluster, find all important cases in the cluster.
- Given a case, find all close contact of the case.