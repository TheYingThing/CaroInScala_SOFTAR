var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "7700",
        "ok": "4030",
        "ko": "3670"
    },
    "minResponseTime": {
        "total": "75",
        "ok": "75",
        "ko": "9554"
    },
    "maxResponseTime": {
        "total": "60016",
        "ok": "59898",
        "ko": "60016"
    },
    "meanResponseTime": {
        "total": "13015",
        "ok": "8806",
        "ko": "17637"
    },
    "standardDeviation": {
        "total": "15281",
        "ok": "11076",
        "ko": "17732"
    },
    "percentiles1": {
        "total": "10004",
        "ok": "3976",
        "ko": "10034"
    },
    "percentiles2": {
        "total": "11532",
        "ok": "13680",
        "ko": "10187"
    },
    "percentiles3": {
        "total": "60000",
        "ok": "33048",
        "ko": "60000"
    },
    "percentiles4": {
        "total": "60001",
        "ok": "57712",
        "ko": "60003"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 770,
    "percentage": 10
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 415,
    "percentage": 5
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 2845,
    "percentage": 37
},
    "group4": {
    "name": "failed",
    "count": 3670,
    "percentage": 48
},
    "meanNumberOfRequestsPerSecond": {
        "total": "17.46",
        "ok": "9.138",
        "ko": "8.322"
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
        "total": "3850",
        "ok": "1569",
        "ko": "2281"
    },
    "minResponseTime": {
        "total": "94",
        "ok": "94",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60016",
        "ok": "59898",
        "ko": "60016"
    },
    "meanResponseTime": {
        "total": "19058",
        "ok": "14472",
        "ko": "22213"
    },
    "standardDeviation": {
        "total": "19039",
        "ok": "14161",
        "ko": "21201"
    },
    "percentiles1": {
        "total": "10148",
        "ok": "11882",
        "ko": "10119"
    },
    "percentiles2": {
        "total": "19095",
        "ok": "18510",
        "ko": "20598"
    },
    "percentiles3": {
        "total": "60000",
        "ok": "39997",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "60003",
        "ok": "58796",
        "ko": "60003"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 250,
    "percentage": 6
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 25,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1294,
    "percentage": 34
},
    "group4": {
    "name": "failed",
    "count": 2281,
    "percentage": 59
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8.73",
        "ok": "3.558",
        "ko": "5.172"
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
        "total": "3850",
        "ok": "2461",
        "ko": "1389"
    },
    "minResponseTime": {
        "total": "75",
        "ok": "75",
        "ko": "8441"
    },
    "maxResponseTime": {
        "total": "54400",
        "ok": "54400",
        "ko": "33895"
    },
    "meanResponseTime": {
        "total": "6972",
        "ok": "5194",
        "ko": "10122"
    },
    "standardDeviation": {
        "total": "5613",
        "ok": "6286",
        "ko": "1337"
    },
    "percentiles1": {
        "total": "10000",
        "ok": "1706",
        "ko": "10004"
    },
    "percentiles2": {
        "total": "10017",
        "ok": "9323",
        "ko": "10019"
    },
    "percentiles3": {
        "total": "16228",
        "ok": "17964",
        "ko": "10109"
    },
    "percentiles4": {
        "total": "21187",
        "ok": "21509",
        "ko": "10507"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 520,
    "percentage": 14
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 390,
    "percentage": 10
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1551,
    "percentage": 40
},
    "group4": {
    "name": "failed",
    "count": 1389,
    "percentage": 36
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8.73",
        "ok": "5.58",
        "ko": "3.15"
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
