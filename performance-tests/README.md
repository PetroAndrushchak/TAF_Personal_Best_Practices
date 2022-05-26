# TAF_Performance testing 

1. Run tests
   
```jmeter -n -t /Users/pandr/WorkSpace/TAF_Personal_Best_Practices/performance-tests/src/test/resources/SearchListings.jmx -l /Users/pandr/WorkSpace/TAF_Personal_Best_Practices/performance-tests/report/results2.jtl```


2. Generate report

```jmeter -n -t /Users/pandr/WorkSpace/TAF_Personal_Best_Practices/performance-tests/src/test/resources/SearchListings.jmx -l /Users/pandr/WorkSpace/TAF_Personal_Best_Practices/performance-tests/report/results.csv -e -o /Users/pandr/WorkSpace/TAF_Personal_Best_Practices/performance-tests/report/htmlReport```