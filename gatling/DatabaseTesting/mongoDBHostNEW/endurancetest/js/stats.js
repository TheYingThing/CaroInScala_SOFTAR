var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1794",
        "ok": "1794",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "71",
        "ok": "71",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "7691",
        "ok": "7691",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1034",
        "ok": "1034",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1284",
        "ok": "1284",
        "ko": "-"
    },
    "percentiles1": {
        "total": "608",
        "ok": "608",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1113",
        "ok": "1113",
        "ko": "-"
    },
    "percentiles3": {
        "total": "3950",
        "ok": "3950",
        "ko": "-"
    },
    "percentiles4": {
        "total": "6973",
        "ok": "6973",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 1089,
    "percentage": 61
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 310,
    "percentage": 17
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 395,
    "percentage": 22
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "13.489",
        "ok": "13.489",
        "ko": "-"
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
        "total": "897",
        "ok": "897",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "176",
        "ok": "176",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "7691",
        "ok": "7691",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1574",
        "ok": "1574",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1607",
        "ok": "1607",
        "ko": "-"
    },
    "percentiles1": {
        "total": "973",
        "ok": "973",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1982",
        "ok": "1981",
        "ko": "-"
    },
    "percentiles3": {
        "total": "4934",
        "ok": "4934",
        "ko": "-"
    },
    "percentiles4": {
        "total": "7401",
        "ok": "7401",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 383,
    "percentage": 43
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 151,
    "percentage": 17
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 363,
    "percentage": 40
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "6.744",
        "ok": "6.744",
        "ko": "-"
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
        "total": "897",
        "ok": "897",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "71",
        "ok": "71",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2129",
        "ok": "2129",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "493",
        "ok": "493",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "362",
        "ok": "362",
        "ko": "-"
    },
    "percentiles1": {
        "total": "417",
        "ok": "417",
        "ko": "-"
    },
    "percentiles2": {
        "total": "731",
        "ok": "731",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1115",
        "ok": "1115",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1607",
        "ok": "1607",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 706,
    "percentage": 79
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 159,
    "percentage": 18
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 32,
    "percentage": 4
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "6.744",
        "ok": "6.744",
        "ko": "-"
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
