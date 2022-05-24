var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "3000",
        "ok": "1625",
        "ko": "1375"
    },
    "minResponseTime": {
        "total": "73",
        "ok": "73",
        "ko": "6815"
    },
    "maxResponseTime": {
        "total": "60009",
        "ok": "57421",
        "ko": "60009"
    },
    "meanResponseTime": {
        "total": "24788",
        "ok": "13009",
        "ko": "38709"
    },
    "standardDeviation": {
        "total": "23484",
        "ok": "14832",
        "ko": "24198"
    },
    "percentiles1": {
        "total": "11169",
        "ok": "8800",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "59570",
        "ok": "15914",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60000",
        "ok": "50425",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "60002",
        "ok": "55042",
        "ko": "60003"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 201,
    "percentage": 7
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 87,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1337,
    "percentage": 45
},
    "group4": {
    "name": "failed",
    "count": 1375,
    "percentage": 46
},
    "meanNumberOfRequestsPerSecond": {
        "total": "31.25",
        "ok": "16.927",
        "ko": "14.323"
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
        "total": "1500",
        "ok": "410",
        "ko": "1090"
    },
    "minResponseTime": {
        "total": "1205",
        "ok": "1205",
        "ko": "6815"
    },
    "maxResponseTime": {
        "total": "60009",
        "ok": "57421",
        "ko": "60009"
    },
    "meanResponseTime": {
        "total": "41565",
        "ok": "29090",
        "ko": "46258"
    },
    "standardDeviation": {
        "total": "22460",
        "ok": "19974",
        "ko": "21531"
    },
    "percentiles1": {
        "total": "59656",
        "ok": "18293",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "49486",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "54364",
        "ko": "60001"
    },
    "percentiles4": {
        "total": "60002",
        "ok": "56118",
        "ko": "60003"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 410,
    "percentage": 27
},
    "group4": {
    "name": "failed",
    "count": 1090,
    "percentage": 73
},
    "meanNumberOfRequestsPerSecond": {
        "total": "15.625",
        "ok": "4.271",
        "ko": "11.354"
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
        "total": "1500",
        "ok": "1215",
        "ko": "285"
    },
    "minResponseTime": {
        "total": "73",
        "ok": "73",
        "ko": "8237"
    },
    "maxResponseTime": {
        "total": "22189",
        "ok": "22189",
        "ko": "16247"
    },
    "meanResponseTime": {
        "total": "8011",
        "ok": "7583",
        "ko": "9838"
    },
    "standardDeviation": {
        "total": "5967",
        "ok": "6547",
        "ko": "765"
    },
    "percentiles1": {
        "total": "8919",
        "ok": "6180",
        "ko": "10000"
    },
    "percentiles2": {
        "total": "11383",
        "ok": "13056",
        "ko": "10001"
    },
    "percentiles3": {
        "total": "19028",
        "ok": "19578",
        "ko": "10004"
    },
    "percentiles4": {
        "total": "21538",
        "ok": "21852",
        "ko": "10059"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 201,
    "percentage": 13
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 87,
    "percentage": 6
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 927,
    "percentage": 62
},
    "group4": {
    "name": "failed",
    "count": 285,
    "percentage": 19
},
    "meanNumberOfRequestsPerSecond": {
        "total": "15.625",
        "ok": "12.656",
        "ko": "2.969"
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
