import xml.etree.ElementTree as ET

from pip import main

'''Process root if any element in root has a child processs them and maintain it on MAP<String,SET()> with table name and columns'''
def hasChildElement(element):
    return len(list(element))


def parser(element, tablename, all_tables): 
    print ("Processing "+element.tag)  
    for child in element:
        print(child.tag, child.attrib)
        if(hasChildElement(child)) > 0 :
            print ("Has nested Child")
            if(child.tag not in all_tables):
                all_tables[child.tag]=set()
            
            parser(child,child.tag,all_tables)

        else:
            print ("no child")
            all_tables[tablename].add(child.tag)
    return all_tables

def createStatement(table,columns):
    query = "create table "+table+" ("
    for val in columns :
        query = query +" "+val+" varchar(225),"
    query = query.rstrip(',')+")"
   
    print(query)
    return query.rstrip(',');



if __name__ == '__main__':
    tree = ET.parse('/Users/vibushanansomasundaram/Documents/SOURCE/GITHUB/Parser/sample.xml')
    
    all_tables=dict()
    
    '''root table'''
    all_tables["roottable"]=set()

    '''Process all root element....'''
    root = tree.getroot()

    detailbillinfo =tree.find("detailbillinfo");

    #ET.dump(detailbillinfo)
    parser(detailbillinfo,"roottable",all_tables)

    print(all_tables)

    queries =[]
    for keys in all_tables:
        queries.append(createStatement(keys,all_tables.get(keys)))
        

    print("allqueries ",queries )


