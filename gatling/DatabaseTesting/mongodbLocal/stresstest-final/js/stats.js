var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2460",
        "ok": "1526",
        "ko": "934"
    },
    "minResponseTime": {
        "total": "78",
        "ok": "78",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60003",
        "ok": "59838",
        "ko": "60003"
    },
    "meanResponseTime": {
        "total": "8898",
        "ok": "7323",
        "ko": "11472"
    },
    "standardDeviation": {
        "total": "7988",
        "ok": "8085",
        "ko": "7111"
    },
    "percentiles1": {
        "total": "10000",
        "ok": "3390",
        "ko": "10001"
    },
    "percentiles2": {
        "total": "10864",
        "ok": "13226",
        "ko": "10001"
    },
    "percentiles3": {
        "total": "19696",
        "ok": "19735",
        "ko": "16984"
    },
    "percentiles4": {
        "total": "40762",
        "ok": "35565",
        "ko": "60000"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 453,
    "percentage": 18
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 201,
    "percentage": 8
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 872,
    "percentage": 35
},
    "group4": {
    "name": "failed",
    "count": 934,
    "percentage": 38
},
    "meanNumberOfRequestsPerSecond": {
        "total": "20.164",
        "ok": "12.508",
        "ko": "7.656"
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
        "ok": "597",
        "ko": "633"
    },
    "minResponseTime": {
        "total": "160",
        "ok": "160",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "60003",
        "ok": "59056",
        "ko": "60003"
    },
    "meanResponseTime": {
        "total": "11497",
        "ok": "10903",
        "ko": "12058"
    },
    "standardDeviation": {
        "total": "8402",
        "ok": "8231",
        "ko": "8523"
    },
    "percentiles1": {
        "total": "10001",
        "ok": "12638",
        "ko": "10001"
    },
    "percentiles2": {
        "total": "13094",
        "ok": "14293",
        "ko": "10001"
    },
    "percentiles3": {
        "total": "21853",
        "ok": "21789",
        "ko": "21786"
    },
    "percentiles4": {
        "total": "60000",
        "ok": "40528",
        "ko": "60000"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 83,
    "percentage": 7
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 20,
    "percentage": 2
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 494,
    "percentage": 40
},
    "group4": {
    "name": "failed",
    "count": 633,
    "percentage": 51
},
    "meanNumberOfRequestsPerSecond": {
        "total": "10.082",
        "ok": "4.893",
        "ko": "5.189"
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
        "ok": "929",
        "ko": "301"
    },
    "minResponseTime": {
        "total": "78",
        "ok": "78",
        "ko": "10000"
    },
    "maxResponseTime": {
        "total": "59838",
        "ok": "59838",
        "ko": "23511"
    },
    "meanResponseTime": {
        "total": "6299",
        "ok": "5022",
        "ko": "10239"
    },
    "standardDeviation": {
        "total": "6595",
        "ok": "7094",
        "ko": "1377"
    },
    "percentiles1": {
        "total": "2837",
        "ok": "941",
        "ko": "10000"
    },
    "percentiles2": {
        "total": "10001",
        "ok": "9954",
        "ko": "10001"
    },
    "percentiles3": {
        "total": "15262",
        "ok": "16255",
        "ko": "10006"
    },
    "percentiles4": {
        "total": "23460",
        "ok": "28761",
        "ko": "16972"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 370,
    "percentage": 30
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 181,
    "percentage": 15
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 378,
    "percentage": 31
},
    "group4": {
    "name": "failed",
    "count": 301,
    "percentage": 24
},
    "meanNumberOfRequestsPerSecond": {
        "total": "10.082",
        "ok": "7.615",
        "ko": "2.467"
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
