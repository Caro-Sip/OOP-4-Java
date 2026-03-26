Param(
    [string[]]$Labs,
    [string]$ScanDir = ".",
    [string]$OutputDir = "reports",
    [string]$FileName = "",
    [string]$StudentName = "insert your name",
    [string]$StudentMajor = "insert your major",
    [string]$StudentCourse = "insert your course",
    [string]$InstructionLink = "link to pdf"
)

Set-StrictMode -Version Latest
$ErrorActionPreference = "Stop"

# Generate one ITC-style markdown report per target folder by reading Ex*.java files.
# Usage:
#   powershell -ExecutionPolicy Bypass -File scripts/generate-itc-report.ps1
#   powershell -ExecutionPolicy Bypass -File scripts/generate-itc-report.ps1 -ScanDir .\archive
#   powershell -ExecutionPolicy Bypass -File scripts/generate-itc-report.ps1 -FileName OOP_Name_03 -Labs lab03
#   powershell -ExecutionPolicy Bypass -File scripts/generate-itc-report.ps1 -Labs lab01, ..\another-project\lab03

if (-not (Test-Path -LiteralPath $OutputDir)) {
    New-Item -ItemType Directory -Path $OutputDir | Out-Null
}

if (-not $Labs -or $Labs.Count -eq 0) {
    $Labs = Get-ChildItem -LiteralPath $ScanDir -Directory -Name | Where-Object { $_ -like "lab*" } | Sort-Object
    if ($Labs) {
        $Labs = $Labs | ForEach-Object { Join-Path $ScanDir $_ }
    }
}

if (-not $Labs -or $Labs.Count -eq 0) {
    Write-Error "No target directories found to scan."
}

$generatedCount = 0
$dateText = Get-Date -Format "yyyy-MM-dd"

foreach ($lab in $Labs) {
    if (-not (Test-Path -LiteralPath $lab -PathType Container)) {
        Write-Host "Skipping $lab (not a directory)."
        continue
    }

    $files = Get-ChildItem -LiteralPath $lab -Filter "Ex*.java" -File | Sort-Object `
        @{ Expression = {
            if ($_.BaseName -match '^Ex(\d+)([A-Za-z]?)_') { [int]$matches[1] } else { [int]::MaxValue }
        } },
        @{ Expression = {
            if ($_.BaseName -match '^Ex\d+([A-Za-z]?)_') { $matches[1] } else { '' }
        } }
    if (-not $files -or $files.Count -eq 0) {
        Write-Host "Skipping $lab (no Ex*.java files found)."
        continue
    }

    $labInfo = Get-Item -LiteralPath $lab
    $labName = $labInfo.Name
    $title = "{0} Report" -f $labName.ToUpperInvariant()
    $reportSlug = ($lab -replace '^[.\\/]+', '') -replace '[\\/]+', '-'
    if ($FileName) {
        $baseFileName = $FileName
        if ($Labs.Count -gt 1) {
            $baseFileName = "{0}-{1}" -f $FileName, $reportSlug
        }
        if ($baseFileName -notmatch '\.md$') {
            $baseFileName = "{0}.md" -f $baseFileName
        }
        $reportFile = Join-Path $OutputDir $baseFileName
    } else {
        $reportFile = Join-Path $OutputDir ("{0}-report.md" -f $reportSlug)
    }

    $builder = New-Object System.Text.StringBuilder

    [void]$builder.AppendLine("---")
    [void]$builder.AppendLine(("created: {0}" -f $dateText))
    [void]$builder.AppendLine(("title: {0}" -f $title))
    [void]$builder.AppendLine('course: "[[OOP-4-Java]]"')
    [void]$builder.AppendLine("tags:")
    [void]$builder.AppendLine("  - studies")
    [void]$builder.AppendLine("  - ITC")
    [void]$builder.AppendLine("---")
    [void]$builder.AppendLine('<div style="font-family: Arial, sans-serif; color: #333; display: flex; flex-direction: column; justify-content: center; align-items: center; text-align: center; min-height: 95vh; width: 100%; padding: 28px 24px; box-sizing: border-box; margin: 0 auto; break-after: page; page-break-after: always;">')
    [void]$builder.AppendLine('<div style="margin-bottom: 30px;">')
    [void]$builder.AppendLine('<img src="https://upload.wikimedia.org/wikipedia/en/f/f7/Institute_of_Technology_of_Cambodia_logo.png" alt="ITC Logo" style="max-width: 150px; height: auto;">')
    [void]$builder.AppendLine("</div>")
    [void]$builder.AppendLine(('<h1 style="margin: 20px 0; color: #1a1a1a; font-size: 32px; font-weight: 700; line-height: 1.2;">{0}</h1>' -f $title))
    [void]$builder.AppendLine('<h2 style="margin: 15px 0; color: #444; font-size: 24px; font-weight: 400; line-height: 1.25;">Object-Oriented Programming Exercises</h2>')
    [void]$builder.AppendLine('<div style="margin-top: 42px; font-size: 18px; line-height: 1.8; text-align: center;">')
    [void]$builder.AppendLine(('<p style="margin: 0;">Student: {0}</p>' -f $StudentName))
    [void]$builder.AppendLine(('<p style="margin: 0;">Major: {0}</p>' -f $StudentMajor))
    [void]$builder.AppendLine(('<p style="margin: 0;">Course: {0}</p>' -f $StudentCourse))
    [void]$builder.AppendLine(('<p style="margin: 0;">Lab: {0}</p>' -f $labName))
    [void]$builder.AppendLine(('<p style="margin: 0;">Date: {0}</p>' -f $dateText))
    [void]$builder.AppendLine("</div>")
    [void]$builder.AppendLine("</div>")
    [void]$builder.AppendLine("")
    [void]$builder.AppendLine("## Overview")
    [void]$builder.AppendLine("")
    [void]$builder.AppendLine(('Student: `{0}`' -f $StudentName))
    [void]$builder.AppendLine(('Major: `{0}`' -f $StudentMajor))
    [void]$builder.AppendLine(('Course: `{0}`' -f $StudentCourse))
    [void]$builder.AppendLine(('Instruction: `{0}`' -f $InstructionLink))
    [void]$builder.AppendLine("")
    [void]$builder.AppendLine("---")
    [void]$builder.AppendLine("")

    foreach ($file in $files) {
        $baseName = [System.IO.Path]::GetFileNameWithoutExtension($file.Name)
        $exTag = $baseName.Split("_")[0]
        $exId = $exTag -replace "^Ex", ""
        $displayPath = ($file.FullName -replace '\\', '/')

        [void]$builder.AppendLine(("## Exercise {0}" -f $exId))
        [void]$builder.AppendLine("")
        [void]$builder.AppendLine("> [!example]")
        [void]$builder.AppendLine(('> Source file: `{0}`' -f $displayPath))
        [void]$builder.AppendLine("")
        [void]$builder.AppendLine('```java')
        [void]$builder.AppendLine((Get-Content -LiteralPath $file.FullName -Raw).TrimEnd())
        [void]$builder.AppendLine('```')
        [void]$builder.AppendLine("")
        [void]$builder.AppendLine("![[Output Image.png]]")
        [void]$builder.AppendLine("")
    }

    Set-Content -LiteralPath $reportFile -Value $builder.ToString() -Encoding UTF8
    $generatedCount++
    Write-Host "Generated $reportFile"
}

if ($generatedCount -eq 0) {
    Write-Error "No reports generated."
}

Write-Host "Done. Generated $generatedCount report(s) in $OutputDir/."
