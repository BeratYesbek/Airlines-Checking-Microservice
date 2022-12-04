package com.beratyesbek.airlinesChecking.grpcService;

import com.beratyesbek.airlinesChecking.dao.BoughtTicketDao;
import com.beratyesbek.airlinesChecking.models.BoughtTicket;
import com.beratyesbek.grpc.BoughtTicketRequest;
import com.beratyesbek.grpc.BoughtTicketServiceGrpc;
import com.beratyesbek.grpc.empty;
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
    public void saveBoughtTicket(BoughtTicketRequest request, StreamObserver<empty> responseObserver) {
        BoughtTicket boughtTicket = modelMapper.map(request, BoughtTicket.class);
        boughtTicketDao.save(boughtTicket);
        super.saveBoughtTicket(request, responseObserver);
    }


}
