package com.beratyesbek.airlinesChecking.grpcService;

import com.beratyesbek.airlinesChecking.dao.BoughtTicketDao;
import com.beratyesbek.airlinesChecking.models.BoughtTicket;
import com.beratyesbek.grpc.BoughtTicketRequest;
import com.beratyesbek.grpc.BoughtTicketResponse;
import com.beratyesbek.grpc.BoughtTicketServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.modelmapper.ModelMapper;

@GrpcService
public class BoughtTicketGrpcServiceImpl extends BoughtTicketServiceGrpc.BoughtTicketServiceImplBase {

    private final BoughtTicketDao boughtTicketDao;
    private final ModelMapper modelMapper;

    public BoughtTicketGrpcServiceImpl(BoughtTicketDao boughtTicketDao, ModelMapper modelMapper) {
        this.boughtTicketDao = boughtTicketDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveBoughtTicket(BoughtTicketRequest request, StreamObserver<BoughtTicketResponse> responseObserver) {
        BoughtTicket boughtTicket = modelMapper.map(request, BoughtTicket.class);
        boughtTicket = boughtTicketDao.save(boughtTicket);
        responseObserver.onNext(BoughtTicketResponse.newBuilder().setId(boughtTicket.getBoughtTicketId()).build());
        responseObserver.onCompleted();
        super.saveBoughtTicket(request, responseObserver);
    }
}
