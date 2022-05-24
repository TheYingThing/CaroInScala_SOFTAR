var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "3000",
        "ok": "1563",
        "ko": "1437"
    },
    "minResponseTime": {
        "total": "78",
        "ok": "78",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60009",
        "ok": "59860",
        "ko": "60009"
    },
    "meanResponseTime": {
        "total": "28502",
        "ok": "13369",
        "ko": "44961"
    },
    "standardDeviation": {
        "total": "24124",
        "ok": "12867",
        "ko": "22692"
    },
    "percentiles1": {
        "total": "17866",
        "ok": "10403",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "22133",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60001",
        "ok": "33374",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60004",
        "ok": "58202",
        "ko": "60004"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 144,
    "percentage": 5
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 109,
    "percentage": 4
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1310,
    "percentage": 44
},
    "group4": {
    "name": "failed",
    "count": 1437,
    "percentage": 48
},
    "meanNumberOfRequestsPerSecond": {
        "total": "22.556",
        "ok": "11.752",
        "ko": "10.805"
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
        "ok": "415",
        "ko": "1085"
    },
    "minResponseTime": {
        "total": "1439",
        "ok": "1439",
        "ko": "10189"
    },
    "maxResponseTime": {
        "total": "60009",
        "ok": "59860",
        "ko": "60009"
    },
    "meanResponseTime": {
        "total": "44431",
        "ok": "20769",
        "ko": "53481"
    },
    "standardDeviation": {
        "total": "22174",
        "ok": "16771",
        "ko": "16616"
    },
    "percentiles1": {
        "total": "60000",
        "ok": "12880",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "31758",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60002",
        "ok": "58099",
        "ko": "60002"
    },
    "percentiles4": {
        "total": "60004",
        "ok": "59678",
        "ko": "60005"
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
    "count": 415,
    "percentage": 28
},
    "group4": {
    "name": "failed",
    "count": 1085,
    "percentage": 72
},
    "meanNumberOfRequestsPerSecond": {
        "total": "11.278",
        "ok": "3.12",
        "ko": "8.158"
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
        "ok": "1148",
        "ko": "352"
    },
    "minResponseTime": {
        "total": "78",
        "ok": "78",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60006",
        "ok": "31545",
        "ko": "60006"
    },
    "meanResponseTime": {
        "total": "12573",
        "ok": "10694",
        "ko": "18699"
    },
    "standardDeviation": {
        "total": "12838",
        "ok": "9838",
        "ko": "18375"
    },
    "percentiles1": {
        "total": "10001",
        "ok": "7990",
        "ko": "10001"
    },
    "percentiles2": {
        "total": "18041",
        "ok": "18794",
        "ko": "10006"
    },
    "percentiles3": {
        "total": "30779",
        "ok": "28031",
        "ko": "60000"
    },
    "percentiles4": {
        "total": "60001",
        "ok": "31189",
        "ko": "60004"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 144,
    "percentage": 10
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 109,
    "percentage": 7
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 895,
    "percentage": 60
},
    "group4": {
    "name": "failed",
    "count": 352,
    "percentage": 23
},
    "meanNumberOfRequestsPerSecond": {
        "total": "11.278",
        "ok": "8.632",
        "ko": "2.647"
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
