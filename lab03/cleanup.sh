#!/bin/bash

# Script to remove duplicate package lab03; declarations

for dir in Ex{1..8}; do
    if [ -d "$dir" ]; then
        for file in "$dir"/*.java; do
            if [ -f "$file" ]; then
                # Remove the "package lab03;" line
                sed -i '/^package lab03;$/d' "$file"
                echo "Cleaned: $file"
            fi
        done
    fi
done

echo "✓ Cleanup complete!"
