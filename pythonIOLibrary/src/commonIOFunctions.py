# cerner_2^5_2019

def read_file_as_str(filename):
    """Reads the content of the files as a string
    Parameters
    ----------
    filename : str
        The name of the file to read with proper path
    Returns
    -------
    str
        The string representation of the file content
    """
    f = open(filename)
    fileContent = f.read()
    f.close()
    return fileContent

def read_file_as_list(filename, delim):
    """Reads the content of the files as a list split as desired
    Parameters
    ----------
    filename : str
        The name of the file to read with proper path
    delim : str
        The delimeter to use when splitting the contents of the file
    Returns
    -------
    list
        The list made by splitting the file content with the provided delimeter
    """
    fileContent = read_file_as_str(filename)
    return fileContent.split(delim)

def read_file_as_dict(filename, list_delim, value_delim):
    """Reads the content of the files as a dictionary split as desired
    Parameters
    ----------
    filename : str
        The name of the file to read with proper path
    list_delim : str
        The delimeter to use when splitting the contents of the file
    value_delim : str
        The delimeter to use when splitting each item/line to get the key & value pairs
    Returns
    -------
    dict
        The dictionary made by splitting the file content with the provided delimeters
    """
    fileAsList = read_file_as_list(filename, list_delim)
    retDict = dict()
    for item in fileAsList:
        itemValues = item.split(value_delim)
        retDict[itemValues[0]] = itemValues[1]