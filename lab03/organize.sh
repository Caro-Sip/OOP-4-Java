#!/bin/bash

# Script to organize Ex# files into Ex{1..8}/ folders with package declarations

# Create directories
for i in {1..8}; do
    mkdir -p "Ex${i}"
done

# Function to add package declaration to a file
add_package_declaration() {
    local file=$1
    local exercise=$2
    
    # Create a temporary file with package declaration
    {
        echo "package Ex${exercise};"
        echo ""
        cat "$file"
    } > "${file}.tmp"
    
    mv "${file}.tmp" "$file"
}

# Process Ex1 files
if [ -f "Ex1_Quadratic.java" ]; then
    add_package_declaration "Ex1_Quadratic.java" "1"
    mv "Ex1_Quadratic.java" "Ex1/"
fi

# Process Ex2 files
if [ -f "Ex2_NTimes.java" ]; then
    add_package_declaration "Ex2_NTimes.java" "2"
    mv "Ex2_NTimes.java" "Ex2/"
fi

# Process Ex3 files
if [ -f "Ex3_Menu.java" ]; then
    add_package_declaration "Ex3_Menu.java" "3"
    mv "Ex3_Menu.java" "Ex3/"
fi

# Process Ex4 files
if [ -f "Ex4_StudentLists.java" ]; then
    add_package_declaration "Ex4_StudentLists.java" "4"
    mv "Ex4_StudentLists.java" "Ex4/"
fi

# Process Ex5 files
if [ -f "Ex5_StaticMath.java" ]; then
    add_package_declaration "Ex5_StaticMath.java" "5"
    mv "Ex5_StaticMath.java" "Ex5/"
fi

# Process Ex6 files
if [ -f "Ex6_StaticMath2.java" ]; then
    add_package_declaration "Ex6_StaticMath2.java" "6"
    mv "Ex6_StaticMath2.java" "Ex6/"
fi

# Process Ex7 files
if [ -f "Ex7_StudentManagement.java" ]; then
    add_package_declaration "Ex7_StudentManagement.java" "7"
    mv "Ex7_StudentManagement.java" "Ex7/"
fi

# Process Ex8 files (multiple files)
for file in Ex8a_StudentDepartment.java Ex8b_PhoneShop.java Ex8c_YouTube.java Ex8d_BookStore.java; do
    if [ -f "$file" ]; then
        add_package_declaration "$file" "8"
        mv "$file" "Ex8/"
    fi
done

echo "✓ Organization complete!"
echo "✓ All files have been moved to their respective Ex{1..8}/ folders"
echo "✓ Package declarations have been added to each file"
