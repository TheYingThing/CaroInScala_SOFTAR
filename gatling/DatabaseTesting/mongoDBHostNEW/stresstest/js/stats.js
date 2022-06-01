var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2460",
        "ok": "1352",
        "ko": "1108"
    },
    "minResponseTime": {
        "total": "74",
        "ok": "74",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60001",
        "ok": "59489",
        "ko": "60001"
    },
    "meanResponseTime": {
        "total": "9643",
        "ok": "8088",
        "ko": "11540"
    },
    "standardDeviation": {
        "total": "8426",
        "ok": "8306",
        "ko": "8180"
    },
    "percentiles1": {
        "total": "10000",
        "ok": "7427",
        "ko": "10000"
    },
    "percentiles2": {
        "total": "10173",
        "ok": "14416",
        "ko": "10001"
    },
    "percentiles3": {
        "total": "18458",
        "ok": "19222",
        "ko": "10006"
    },
    "percentiles4": {
        "total": "57456",
        "ok": "32775",
        "ko": "60000"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 277,
    "percentage": 11
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 181,
    "percentage": 7
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 894,
    "percentage": 36
},
    "group4": {
    "name": "failed",
    "count": 1108,
    "percentage": 45
},
    "meanNumberOfRequestsPerSecond": {
        "total": "19.37",
        "ok": "10.646",
        "ko": "8.724"
    }
},
contents: {
"req_load-ec4d1": {
        type: "REQUEST",
        name: "load",
path: "load",
pathFormatted: "req_load-ec4d1",
stats: {
    "name": "load",
    "numberOfRequests": {
        "total": "1230",
        "ok": "500",
        "ko": "730"
    },
    "minResponseTime": {
        "total": "201",
        "ok": "201",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60001",
        "ok": "59489",
        "ko": "60001"
    },
    "meanResponseTime": {
        "total": "12155",
        "ok": "12529",
        "ko": "11899"
    },
    "standardDeviation": {
        "total": "9119",
        "ok": "9170",
        "ko": "9075"
    },
    "percentiles1": {
        "total": "10001",
        "ok": "14695",
        "ko": "10000"
    },
    "percentiles2": {
        "total": "14342",
        "ok": "16601",
        "ko": "10001"
    },
    "percentiles3": {
        "total": "21886",
        "ok": "22339",
        "ko": "11198"
    },
    "percentiles4": {
        "total": "60000",
        "ok": "56222",
        "ko": "60000"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 80,
    "percentage": 7
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 7,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 413,
    "percentage": 34
},
    "group4": {
    "name": "failed",
    "count": 730,
    "percentage": 59
},
    "meanNumberOfRequestsPerSecond": {
        "total": "9.685",
        "ok": "3.937",
        "ko": "5.748"
    }
}
    },"req_save-43781": {
        type: "REQUEST",
        name: "save",
path: "save",
pathFormatted: "req_save-43781",
stats: {
    "name": "save",
    "numberOfRequests": {
        "total": "1230",
        "ok": "852",
        "ko": "378"
    },
    "minResponseTime": {
        "total": "74",
        "ok": "74",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60000",
        "ok": "56890",
        "ko": "60000"
    },
    "meanResponseTime": {
        "total": "7131",
        "ok": "5482",
        "ko": "10846"
    },
    "standardDeviation": {
        "total": "6799",
        "ok": "6462",
        "ko": "6030"
    },
    "percentiles1": {
        "total": "9989",
        "ok": "1311",
        "ko": "10000"
    },
    "percentiles2": {
        "total": "10001",
        "ok": "10768",
        "ko": "10001"
    },
    "percentiles3": {
        "total": "15232",
        "ok": "15716",
        "ko": "10003"
    },
    "percentiles4": {
        "total": "30095",
        "ok": "21382",
        "ko": "57131"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 197,
    "percentage": 16
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 174,
    "percentage": 14
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 481,
    "percentage": 39
},
    "group4": {
    "name": "failed",
    "count": 378,
    "percentage": 31
},
    "meanNumberOfRequestsPerSecond": {
        "total": "9.685",
        "ok": "6.709",
        "ko": "2.976"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
