# Example of web scraping 

# How to

## Set up the project

The requirements for the projects are :

- Java

The scraper is a Java application. You need Java to execute it. ([Java download page](https://www.oracle.com/technetwork/java/javase/downloads/index.html))

- Maven

This is a Maven project, the second thing you need to do to install Maven. You can find more detail to install it at the [project official page](https://maven.apache.org/).

## Run de scraper

```bash
mvn exec:java
```
If the build is a success, you should have an updated version of the file `results.json`. 

If the build didn't succeed, you should have an open Chrome window with a page that requires a human interaction.



If something went wrong and you don't know what to do, please raise an issue on this repo!

## Example of possible `results.json`

```JSON
{
  "sectors": [
    {
      "name": "Label",
      "performances": [
        {
          "name": "Label",
          "value": "+0.50%"
        },
        {
          "name": "Label",
          "value": "+1.24%"
        },
        {
          "name": "Label",
          "value": "+1.09%"
        },
        {
          "name": "Label",
          "value": "+0.94%"
        },
        {
          "name": "Label",
          "value": "+0.91%"
        }
      ]
    },
    {
      "name": "Label",
      "performances": [
        {
          "name": "Label",
          "value": "+0.32%"
        },
        {
          "name": "Label",
          "value": "+1.04%"
        },
        {
          "name": "Label",
          "value": "+0.89%"
        }
      ]
    },
    {
      "name": "Label",
      "performances": [
        {
          "name": "Label",
          "value": "+0.76%"
        }
      ]
    },
    {
      "name": "Label",
      "performances": [
        {
          "name": "Label",
          "value": "+0.72%"
        }
      ]
    },
    {
      "name": "Label",
      "performances": [
        {
          "name": "Label",
          "value": "+0.75%"
        },
        {
          "name": "Label",
          "value": "+0.90%"
        },
        {
          "name": "Label",
          "value": "+0.57%"
        }
      ]
    },
    {
      "name": "Label",
      "performances": [
        {
          "name": "Label",
          "value": "+1.70%"
        },
        {
          "name": "Label",
          "value": "-0.10%"
        },
        {
          "name": "Label",
          "value": "+0.54%"
        }
      ]
    },
    {
      "name": "Label",
      "performances": [
        {
          "name": "Label",
          "value": "+0.59%"
        },
        {
          "name": "Label",
          "value": "-0.06%"
        },
        {
          "name": "Label",
          "value": "+0.79%"
        }
      ]
    },
    {
      "name": "Label",
      "performances": [
        {
          "name": "Label",
          "value": "+0.99%"
        },
        {
          "name": "Label",
          "value": "+0.03%"
        }
      ]
    },
    {
      "name": "Label",
      "performances": [
        {
          "name": "Label",
          "value": "+0.36%"
        }
      ]
    },
    {
      "name": "Label",
      "performances": [
        {
          "name": "Label",
          "value": "+0.26%"
        }
      ]
    },
    {
      "name": "Label",
      "performances": [
        {
          "name": "Label",
          "value": "+0.17%"
        }
      ]
    }
  ]
}
```

