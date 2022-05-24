var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "1712",
        "ok": "1712",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "72",
        "ok": "72",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "5135",
        "ok": "5135",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1306",
        "ok": "1306",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1255",
        "ok": "1255",
        "ko": "-"
    },
    "percentiles1": {
        "total": "835",
        "ok": "835",
        "ko": "-"
    },
    "percentiles2": {
        "total": "2045",
        "ok": "2045",
        "ko": "-"
    },
    "percentiles3": {
        "total": "4035",
        "ok": "4035",
        "ko": "-"
    },
    "percentiles4": {
        "total": "4755",
        "ok": "4755",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 832,
    "percentage": 49
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 192,
    "percentage": 11
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 688,
    "percentage": 40
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "12.776",
        "ok": "12.776",
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
        "total": "856",
        "ok": "856",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "93",
        "ok": "93",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "5135",
        "ok": "5135",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1900",
        "ok": "1900",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1463",
        "ok": "1463",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1859",
        "ok": "1859",
        "ko": "-"
    },
    "percentiles2": {
        "total": "2981",
        "ok": "2981",
        "ko": "-"
    },
    "percentiles3": {
        "total": "4350",
        "ok": "4350",
        "ko": "-"
    },
    "percentiles4": {
        "total": "4827",
        "ok": "4827",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 295,
    "percentage": 34
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 40,
    "percentage": 5
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 521,
    "percentage": 61
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "6.388",
        "ok": "6.388",
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
        "total": "856",
        "ok": "856",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "72",
        "ok": "72",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2661",
        "ok": "2661",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "713",
        "ok": "713",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "555",
        "ok": "555",
        "ko": "-"
    },
    "percentiles1": {
        "total": "619",
        "ok": "619",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1036",
        "ok": "1036",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1852",
        "ok": "1852",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2295",
        "ok": "2295",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 537,
    "percentage": 63
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 152,
    "percentage": 18
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 167,
    "percentage": 20
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "6.388",
        "ok": "6.388",
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
