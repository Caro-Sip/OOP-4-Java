# ITC Report Generators

This folder contains scripts that read `Ex*.java` files and generate Markdown reports using your ITC report format.

## Files

- `generate-itc-report.sh` (Bash)
- `generate-itc-report.ps1` (PowerShell)

## Bash usage (recommended)

Run from repository root.

### 1. Default behavior

Scan subdirectories named `lab*` in the current directory and generate reports in `reports/`:

```bash
bash scripts/generate-itc-report.sh
```

### 2. Scan another root directory

If your labs are in another location, use `--scan-dir`:

```bash
bash scripts/generate-itc-report.sh --scan-dir ../old-semester
```

This scans `../old-semester` for folders matching `lab*` and generates one report per folder.

### 3. Scan specific directories (any path)

Pass directories directly (relative or absolute):

```bash
bash scripts/generate-itc-report.sh lab01 lab03
bash scripts/generate-itc-report.sh ../backup/lab02 /d/MyLife/JavaLabs/lab04
```

Each target directory is scanned for `Ex*.java` files.

### 4. Choose exact output file name (your example)

Generate only lab03 and force output file name to `OOP_Name_03.md`:

```bash
bash scripts/generate-itc-report.sh --file-name OOP_Name_03 lab03
```

If you provide multiple target directories together with `--file-name`, the script appends a suffix to avoid overwrite.

### 5. Set your name, major, and course

```bash
OUTPUT_DIR=my-reports \
FILE_NAME="OOP_Name_03" \
STUDENT_NAME="Your Name" \
STUDENT_MAJOR="Your Major" \
STUDENT_COURSE="OOP 4" \
INSTRUCTION_LINK="https://example.com/lab.pdf" \
bash scripts/generate-itc-report.sh lab03
```

Environment variables:

- `OUTPUT_DIR` default: `reports`
- `FILE_NAME` default: empty (auto-generated from folder path)
- `STUDENT_NAME` default: `insert your name`
- `STUDENT_MAJOR` default: `insert your major`
- `STUDENT_COURSE` default: `insert your course`
- `INSTRUCTION_LINK` default: `link to pdf`
- `SCAN_DIR` default: `.` (used when no directory arguments are passed)

### 6. Help

```bash
bash scripts/generate-itc-report.sh --help
```

## PowerShell usage

### 1. Default behavior

```powershell
powershell.exe -NoProfile -ExecutionPolicy Bypass -File scripts/generate-itc-report.ps1
```

### 2. Scan another root directory

```powershell
powershell.exe -NoProfile -ExecutionPolicy Bypass -File scripts/generate-itc-report.ps1 -ScanDir ..\old-semester
```

### 3. Scan specific directories (any path)

```powershell
powershell.exe -NoProfile -ExecutionPolicy Bypass -File scripts/generate-itc-report.ps1 -Labs lab01, ..\backup\lab02, D:\MyLife\JavaLabs\lab04
```

### 4. Customize output and metadata

```powershell
powershell.exe -NoProfile -ExecutionPolicy Bypass -File scripts/generate-itc-report.ps1 `
  -OutputDir my-reports `
  -FileName "OOP_Name_03" `
  -StudentName "Your Name" `
  -StudentMajor "Your Major" `
  -StudentCourse "OOP 4" `
  -InstructionLink "https://example.com/lab.pdf" `
  -Labs lab03
```

## Notes

- A report is generated only for directories that contain at least one `Ex*.java` file.
- Output file names are path-safe, so scanning nested folders will still produce valid report names.
